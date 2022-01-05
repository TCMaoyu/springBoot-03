package cn.whut.springboot03.controller;

import cn.whut.springboot03.dao.DataMapper;
import cn.whut.springboot03.dao.SearchMapper;
import cn.whut.springboot03.pojo.Data;
import cn.whut.springboot03.pojo.SearchLoc;
import cn.whut.springboot03.services.DataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    DataMapper dataMapper;

    @Autowired
    SearchMapper searchMapper;

    @RequestMapping("user/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        if(!StringUtils.isEmpty(password)&&name.equals("admin")){
            session.setAttribute("LoginUser",name);   //设置session
            List<Data> allData = dataMapper.getAll();
            model.addAttribute("allData", allData);
            return "index";
        }
        else{
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }
    }

    @RequestMapping("user/logOut")
    public String loginOut(HttpSession session){
        session.invalidate();  //注销session
        return "login";
    }


    @Controller
    public class admin{
        @RequestMapping("/")
        public String index() {
            return "login";
        }
    }

    @RequestMapping("/insertData")
    public String data() {
        new DataReader().insertData(dataMapper);
        return "index";
    }

    @ResponseBody
    @RequestMapping("searchFlow")
    public void searchFlow() {
        SearchLoc searchLoc = new SearchLoc();
        searchLoc.Loca1_Lat = (float)103.98145;
        searchLoc.Loca1_Lon = (float)30.68774;
        searchLoc.Loca2_Lat = (float)104.03592;
        searchLoc.Loca2_Lon = (float)30.67883;
        searchLoc.Loca3_Lat = (float)104.04160;
        searchLoc.Loca3_Lon = (float)30.67589;
        searchLoc.Loca4_Lat = (float)103.99002;
        searchLoc.Loca4_Lon = (float)30.56686;

        int i = searchMapper.searchDataByLoc(searchLoc);
        System.out.println(i);
    }

    // 同过前端传递的时间参数来获取数据

    @RequestMapping("/SearchByTime")
    public String searchByTime(@RequestParam("beginTime") String beginTime,
                               @RequestParam("endTime") String endTime,
                               Model model) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = format.parse(beginTime);//转换成格林威治时间
        Long timeLongNumBegin = beginDate.getTime();//开始时间转换成时间戳

        Date endDate = format.parse(endTime);//转换成格林威治时间
        Long timeLongNumEnd = endDate.getTime();//开始时间转换成时间戳

        //转为python10位时间戳格式
        timeLongNumBegin = timeLongNumBegin/1000;
        timeLongNumEnd = timeLongNumEnd/1000;

        String begin = String.valueOf(timeLongNumBegin);
        String end = String.valueOf(timeLongNumEnd);
        List<Data> dataByTime = dataMapper.getDataByTime(begin, end);
        model.addAttribute("allData", dataByTime);
        return "index";
    }


}

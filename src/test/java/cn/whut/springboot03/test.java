package cn.whut.springboot03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2016-12-01 00:30:00";    // 1480521600000   1480522500000  1480523400000
        Date date = format.parse(time);//转换成格林威治时间
        Long timeLongNum = date.getTime();//转换为时间戳
        System.out.println(timeLongNum);
        System.out.println(1480523400000l-1480521600000l);
//        long a = 1480497562000l;
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(a))));      // 时间戳转换成时间
//        System.out.println("格式化结果：" + sd);
    }
}

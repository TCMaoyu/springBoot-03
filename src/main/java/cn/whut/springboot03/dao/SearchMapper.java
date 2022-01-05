package cn.whut.springboot03.dao;

import cn.whut.springboot03.pojo.SearchLoc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @date
 * @function
 */

@Mapper
@Repository
public interface SearchMapper {
    //根据经纬度查询这个区域的交通流量
    public int searchDataByLoc(SearchLoc searchLoc);
}

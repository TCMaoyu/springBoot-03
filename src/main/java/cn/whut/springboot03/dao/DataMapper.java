package cn.whut.springboot03.dao;


import cn.whut.springboot03.pojo.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DataMapper {

    // 把数据从csv文件读取后存储在数据库中
    void insertData(Data data);

    // 获取所有的数据
    List<Data> getAll();

    // 根据时间来获取数据
    List<Data> getDataByTime(String begin, String end);
}

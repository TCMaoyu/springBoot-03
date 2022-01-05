package cn.whut.springboot03.services;

import cn.whut.springboot03.dao.DataMapper;
import cn.whut.springboot03.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class DataReader {



    public void insertData(DataMapper dataMapper) {
        // 1. .csv文件的路径。注意只有一个\的要改成\\
        File csv = new File(
                "C:\\Users\\AS\\Desktop\\didi_chengdu.csv"); // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            int i =0;
            Data data = new Data();
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                // 去掉首行
                if (i == 0) {
                    i++;
                    continue;
                } else {
                    everyLine = line;
                    String[] str = everyLine.split(",");
                    data.orderId = str[0];
                    data.beginTime = Long.valueOf(str[1]);
                    data.endTime = Long.valueOf(str[2]);
                    data.beginLon = Float.valueOf(str[3]);
                    data.beginLat = Float.valueOf(str[4]);
                    data.endLon = Float.valueOf(str[7]);
                    data.endLat = Float.valueOf(str[8]);

                    dataMapper.insertData(data);
                }
                i++;

            }
            System.out.println("csv表格中所有行数：" + i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
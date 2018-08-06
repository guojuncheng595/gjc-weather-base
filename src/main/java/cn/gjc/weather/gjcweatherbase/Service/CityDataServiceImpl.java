package cn.gjc.weather.gjcweatherbase.Service;

import cn.gjc.weather.gjcweatherbase.util.XmlBuilder;
import cn.gjc.weather.gjcweatherbase.vo.City;
import cn.gjc.weather.gjcweatherbase.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author: GuoJunCheng
 * @Description: City Data Service
 * @Date: 17:10 2018/8/5
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件
        ClassPathResource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        //数据转换成Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());

        return cityList.getCityList();
    }
}

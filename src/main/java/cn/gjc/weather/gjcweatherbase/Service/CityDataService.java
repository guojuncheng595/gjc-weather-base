package cn.gjc.weather.gjcweatherbase.Service;

import cn.gjc.weather.gjcweatherbase.vo.City;

import java.util.List;

/**
 *@Author: GuoJunCheng
 *@Description: City Data Service
 *@Date: 17:10 2018/8/5
 */
public interface CityDataService {
    /**
     *@Author: GuoJunCheng
     *@Description: 获取city列表
     *@Date: 17:12 2018/8/5
     */
    List<City> listCity() throws Exception;
}

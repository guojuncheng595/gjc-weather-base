package cn.gjc.weather.gjcweatherbase.Service;

import cn.gjc.weather.gjcweatherbase.vo.Weather;

/**
 *@Author: GuoJunCheng
 *@Description: Weather Report Service
 *@Date: 21:32 2018/8/7
 */
public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}

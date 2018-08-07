package cn.gjc.weather.gjcweatherbase.Service;

import cn.gjc.weather.gjcweatherbase.vo.Weather;
import cn.gjc.weather.gjcweatherbase.vo.WeatherResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author: GuoJunCheng
 *@Description: Weather Report ServiceImpl
 *@Date: 21:34 2018/8/7
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }
}

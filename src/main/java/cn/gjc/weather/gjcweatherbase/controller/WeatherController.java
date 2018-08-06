package cn.gjc.weather.gjcweatherbase.controller;

import cn.gjc.weather.gjcweatherbase.Service.WeatherDataService;
import cn.gjc.weather.gjcweatherbase.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GuoJunCheng
 * @Description:
 * @Date: 12:38 2018/8/5
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;


    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByName(cityName);
    }

    @GetMapping("/hello")
    public String getHello() {
        return "文文是傻逼";
    }
}

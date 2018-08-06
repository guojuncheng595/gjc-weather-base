package cn.gjc.weather.gjcweatherbase.job;

import cn.gjc.weather.gjcweatherbase.Service.CityDataService;
import cn.gjc.weather.gjcweatherbase.Service.WeatherDataService;
import cn.gjc.weather.gjcweatherbase.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @Author: GuoJunCheng
 * @Description: Weather Data Sync Job
 * @Date: 16:35 2018/8/5
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job Start");
        //获取城市列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.info("Exception!", e);
        }
        // 遍历城市id获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync job ,cityId: " + cityId);
            weatherDataService.syncDateByCityId(cityId);
        }

        logger.info("Weather Data Sync job End");


    }
}

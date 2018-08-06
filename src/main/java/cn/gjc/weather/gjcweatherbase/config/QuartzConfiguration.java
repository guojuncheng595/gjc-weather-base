package cn.gjc.weather.gjcweatherbase.config;

import cn.gjc.weather.gjcweatherbase.job.WeatherDataSyncJob;
import org.omg.CORBA.TIMEOUT;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GuoJunCheng
 * @Description: 获取网络天气数据定时任务
 * @Date: 16:38 2018/8/5
 */
@Configuration
public class QuartzConfiguration {
    private static final int TIME = 1800;

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weather data")
                .storeDurably().build();

    }

    //Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}

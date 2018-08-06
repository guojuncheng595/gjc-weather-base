package cn.gjc.weather.gjcweatherbase.Service;

import cn.gjc.weather.gjcweatherbase.vo.WeatherResponse;

/**
 * @Author: GuoJunCheng
 * @Description: 天气数据服务
 * @Date: 10:21 2018/8/5
 */
public interface WeatherDataService {

    /**
     * @Author: GuoJunCheng
     * @Description: 根据城市id查询城市数据
     * @Date: 10:25 2018/8/5
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * @Author: GuoJunCheng
     * @Description: 根据城市名称查询城市数据
     * @Date: 10:25 2018/8/5
     */
    WeatherResponse getDataByName(String cityName);

    /**
     * @Author: GuoJunCheng
     * @Description: 根据城市id 来同步数据
     * @Date: 17:21 2018/8/5
     */
    void syncDateByCityId(String cityId);
}

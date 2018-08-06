package cn.gjc.weather.gjcweatherbase.Service;

import cn.gjc.weather.gjcweatherbase.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: GuoJunCheng
 * @Description: 天气数据服务实现
 * @Date: 10:27 2018/8/5
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataService.class);
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 1800L; //1800s

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URL + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByName(String cityName) {
        String uri = WEATHER_URL + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        String key = uri;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String body = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        if (stringRedisTemplate.hasKey(key)) {
            //先查询缓存
            logger.info("Redis has data");
            body = ops.get(key);
        } else {
            //在请求网络
            logger.info("Redis nots has data");
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            if (respString.getStatusCodeValue() == 200) {
                body = respString.getBody();
            }
            //数据写入缓存中
            ops.set(key, body, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            resp = mapper.readValue(body, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Error!", e);
        }
        return resp;
    }


    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URL + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * @Author: GuoJunCheng
     * @Description: 把天气数据放到缓存中
     * @Date: 17:22 2018/8/5
     */
    private void saveWeatherData(String uri) {

        String key = uri;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String body = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCodeValue() == 200) {
            body = respString.getBody();
        }
        //数据写入缓存中
        ops.set(key, body, TIME_OUT, TimeUnit.SECONDS);
    }
}

package cn.gjc.weather.gjcweatherbase.vo;

import cn.gjc.weather.gjcweatherbase.vo.Weather;
import lombok.Data;

import java.io.Serializable;

/**
 *@Author: GuoJunCheng
 *@Description: 天气接口返回对象
 *@Date: 10:17 2018/8/5
 */
@Data
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = -6454774086180071760L;
    private Weather data;
    private Integer status;
    private String desc;
}

package cn.gjc.weather.gjcweatherbase.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: GuoJunCheng
 * @Description: 未来的天气
 * @Date: 10:10 2018/8/5
 */
@Data
public class Forecast implements Serializable {

    private static final long serialVersionUID = -6894230888275061679L;
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}

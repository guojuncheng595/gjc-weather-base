package cn.gjc.weather.gjcweatherbase.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: GuoJunCheng
 * @Description: 昨天的天气
 * @Date: 10:10 2018/8/5
 */
@Data
public class Yesterday implements Serializable {

    private static final long serialVersionUID = 6100346196475767991L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;

}

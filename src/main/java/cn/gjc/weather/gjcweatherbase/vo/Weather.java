package cn.gjc.weather.gjcweatherbase.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *@Author: GuoJunCheng
 *@Description:
 *@Date: 10:08 2018/8/5
 */

@Data
public class Weather  implements Serializable {
    private static final long serialVersionUID = -6870183000779821337L;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;


}

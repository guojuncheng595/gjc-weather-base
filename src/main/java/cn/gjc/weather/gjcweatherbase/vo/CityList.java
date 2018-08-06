package cn.gjc.weather.gjcweatherbase.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author: GuoJunCheng
 * @Description: city list
 * @Date: 16:59 2018/8/5
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;
}

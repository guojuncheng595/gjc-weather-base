package cn.gjc.weather.gjcweatherbase.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 *@Author: GuoJunCheng
 *@Description: City
 *@Date: 16:52 2018/8/5
 */
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class City {

    @XmlAttribute(name = "d1")
    private String cityId;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String cityCode;

    @XmlAttribute(name = "4")
    private String province;

	
	
	
}

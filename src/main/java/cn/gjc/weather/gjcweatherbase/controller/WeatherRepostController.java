package cn.gjc.weather.gjcweatherbase.controller;

import cn.gjc.weather.gjcweatherbase.Service.CityDataService;
import cn.gjc.weather.gjcweatherbase.Service.WeatherReportService;
import cn.gjc.weather.gjcweatherbase.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: GuoJunCheng
 * @Description: Weather Repost Controller
 * @Date: 21:37 2018/8/7
 */
@Controller
@RequestMapping("report")
public class WeatherRepostController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,Model model) throws Exception {

        model.addAttribute("title", "老郭的天气！");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
    }
}

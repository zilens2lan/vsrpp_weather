package com.zilen.weatherthymeleaf.weatherApp.controller;

import com.zilen.weatherthymeleaf.weatherApp.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/weather-gui")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("weatherForecast", weatherService.getWeatherForecast());
        model.addAttribute("setwoeid", new WeatherService());
        model.addAttribute("dayaftertomorrow", LocalDate.now().plusDays(2).toString());
        model.addAttribute("threedaysfromtoday", LocalDate.now().plusDays(3).toString());
        return "weather-gui/weather_view";
    }

    @PostMapping
    public String changeCity(@RequestParam int woeid) {
        this.weatherService.setWoeid(woeid);
        return "redirect:/weather-gui";
    }
}

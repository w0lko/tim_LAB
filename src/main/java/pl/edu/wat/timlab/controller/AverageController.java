package pl.edu.wat.timlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.timlab.Numbers;
import pl.edu.wat.timlab.service.AverageService;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/average")
public class AverageController {

    @Autowired
    AverageService averageService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Map<String,Object> getAverage(@RequestBody Numbers numbers){
        Map<String,Object> model = new HashMap<>();
        double average = averageService.getAverage(numbers.getNumbers());
        model.put("average",average);
        return model;
    }
}

package pl.edu.wat.timlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.timlab.service.RandomService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/random")
public class RandomController {

    @Autowired
    RandomService randomService;


    @PreAuthorize("hasRole('RANDOMER')")
    @RequestMapping(value = "/{amount}", method = RequestMethod.GET)
    public Map<String,Object> getRandomNumbers(@PathVariable("amount") int amount){
        Map<String,Object> model = new HashMap<>();
        List<Integer> numbers = randomService.getRandom(amount);

        model.put("numbers",numbers);

        return model;
    }

    @RequestMapping(value = "/list/{amount}", method = RequestMethod.GET)
    public List<Integer> getRandomNumbersList(@PathVariable("amount") int amount){
        return randomService.getRandom(amount);
    }

}

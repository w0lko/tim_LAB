package pl.edu.wat.timlab.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.wat.timlab.service.RandomService;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


@Service
@Slf4j
public class RandomServiceImpl implements RandomService {


    @Override
    public List<Integer> getRandom(int amount) {
        if(amount < 1){
            return null;
        }

        List<Integer> numbers = new LinkedList<>();
        Random r = new Random();
        for(int i = 0;i<amount;i++){
            numbers.add(r.nextInt(100));
        }

        return numbers;
    }
}

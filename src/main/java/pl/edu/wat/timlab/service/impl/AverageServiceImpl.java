package pl.edu.wat.timlab.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.wat.timlab.service.AverageService;

import java.util.List;


@Service
@Slf4j
public class AverageServiceImpl implements AverageService {

    @Override
    public double getAverage(List<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }

        double avg = 0;

        for(Integer n: numbers){
            avg += n;
        }
        avg /= numbers.size();

        return avg;
    }
}

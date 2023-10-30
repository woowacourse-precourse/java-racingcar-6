package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gameService {
    public List<String> splitCarNames(String input){
        String [] carString = input.split(",");
        List<String> carList = new ArrayList<String>(Arrays.asList(carString));
        return carList;
    }
}

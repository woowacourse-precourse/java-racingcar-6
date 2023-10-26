package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarCreator {
    public List<String> createCarList(String inputItem){
        return Arrays.asList(inputItem.split(","));
    }
}

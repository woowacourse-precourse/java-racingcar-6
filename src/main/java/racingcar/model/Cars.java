package racingcar.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Cars {
    List<String> carsName;
    Map<String, Integer> carsScore;

    public Cars() {
        carsScore = new HashMap<String, Integer>();
    }

    public void addCar(String carsName){
        this.carsName = Arrays.asList(carsName.split(","));
        this.carsName.forEach(carName -> carsScore.put(carName, 0));
    }
}

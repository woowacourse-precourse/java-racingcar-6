package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Car {
    List<String> cars = new ArrayList<>();
    String car;
    public List<String> name(String carName){
        StringTokenizer sToken = new StringTokenizer(carName);
        while(sToken.hasMoreElements()) {
            car = sToken.nextToken(",");
            if(car.length() < 6 ){
                cars.add(car);
            }else{
                throw new IllegalArgumentException();
            }
        }
        return cars;
    }
}

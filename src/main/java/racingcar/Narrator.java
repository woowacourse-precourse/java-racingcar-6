package racingcar;

import java.util.List;

public class Narrator {

    public void showEachRound(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.name+" : "+String.join("", car.distance));
        }
        System.out.println();
    }
}

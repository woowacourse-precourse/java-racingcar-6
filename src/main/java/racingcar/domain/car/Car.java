package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomUtil;
import racingcar.util.Validator.Validator;

public class Car {

    private String name;

    private int distance;

    public Car() {
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car of(String name){
        return new Car(name, 0);
    }

    public String getCarName(){
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }

    public void updateCarDistance(){
        int randomNumber = RandomUtil.generateRandomNumber();
        boolean isCanForward = Validator.isCanForward(randomNumber);
        if (isCanForward){
            distance += 1;
        }
    }

    public List<Car> createCars(){
        return new ArrayList<Car>();
    }

}

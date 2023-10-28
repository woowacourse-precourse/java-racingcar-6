package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private final static int MAX_LENGTH = 5;
    private final static int FORWARD_THRESHOLD = 4;

    private boolean inputValidation(String name){
        return name.length() <= MAX_LENGTH;
    }

    public void setUp(List<String> names){
        for(String name: names){
            if(!inputValidation(name)){
                throw new IllegalArgumentException("Exceeds maximum input length " + MAX_LENGTH);
            }
            cars.add(new Car(name));
        }
    }

    public void printCars(){
        for(Car car: cars){
            System.out.print(car.getName()+",");
        }
    }
}

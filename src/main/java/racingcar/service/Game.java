package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
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

    public boolean moveForwardAttempt(){
        return Randoms.pickNumberInRange(0,9) >= FORWARD_THRESHOLD ;
    }

    public void moveForwardAttemptCars(){
        for(Car car: cars){
            if(moveForwardAttempt()){
                car.moveForward();
            }
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public Integer getMaxPosition(){
        return cars.stream().max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new).getPosition();
    }

    public List<String> getFinalists(){
        int maxPosition = getMaxPosition();

        //우승자만 필터링하고 name field만 collect해 반환
        return cars.stream().filter(car -> maxPosition == car.getPosition())
                .map(Car::getName).collect(Collectors.toList());
    }
}

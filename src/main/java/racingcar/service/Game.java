package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;

public class Game {
    private List<Car> cars = new ArrayList<>();

    public void setUp(List<String> names){
        for(String name: names){
            cars.add(new Car(name));
        }
    }

    public boolean moveForwardAttempt(Integer input){
        return input >= Constant.FORWARD_THRESHOLD ;
    }

    public void moveForwardAttemptCars(){
        for(Car car: cars){
            if(moveForwardAttempt(Randoms.pickNumberInRange(Constant.MIN_NUMBER,Constant.MAX_NUMBER))){
                car.moveForward();
            }
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public Integer getMaxPosition(){
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }

    public List<String> getFinalists(){
        int maxPosition = getMaxPosition();

        //우승자만 필터링하고 name field만 collect해 반환
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .toList();
    }
}

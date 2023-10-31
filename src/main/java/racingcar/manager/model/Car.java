package racingcar.manager.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carName;
    private Integer moveCount;
    private static Integer MOVE_CONDITION = 4;
    public Car(){

    }
    public Car(String carName, Integer moveCount){
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public List<Car> getCarList(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName, 0));
        }
        return cars;
    }
    public String getCarName(){
        return this.carName;
    }
    public Integer getMoveCount(){
        return this.moveCount;
    }
    public void moveOrStop(Integer randomNumber){
        if(randomNumber>=MOVE_CONDITION){
            this.moveCount++;
        }
    }

}

package racingcar.manager.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Car {
    private String carName;
    private Integer moveCount;

    public Car(){
        this.carName = null;
        this.moveCount = 0;
    }
    public Car(String carName, Integer moveCount){
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public static List<Car> getCarList(List<String> carNames){
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

    public void setMoveCount(Integer moveCount){
        this.moveCount=moveCount;
    }


}

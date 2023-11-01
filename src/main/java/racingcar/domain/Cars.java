package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }

    public void moveOrStop() {
        for(Car car : carList){
            if(car.canMove(Randoms.pickNumberInRange(1, 9))){
                car.move();
            }
        }
    }

    public String getEachRoundResult() {
        StringBuilder result = new StringBuilder();
        for(Car car : carList){
            result.append(car.getName());
            result.append(" : ");
            result.append(car.distanceToHyphen());
            result.append("\n");
        }
        return result.toString();
    }
}

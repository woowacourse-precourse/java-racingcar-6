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

    public String getWinner() {
        List<String> winner = new ArrayList<>();
        int maxDistance = 0;
        for(Car car : carList){
            if(maxDistance == car.getDistance()){
                winner.add(car.getName());
            } else if (maxDistance < car.getDistance()) {
                winner.clear();
                winner.add(car.getName());
                maxDistance = car.getDistance();
            }
        }
        return String.join(",", winner);
    }
}

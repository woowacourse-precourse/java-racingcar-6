package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    List<RacingCar> carList;
    public List<RacingCar> initCars(List<String> nameList) {
        carList = new ArrayList<>();
        for(String name : nameList) {
            carList.add(new RacingCar(name));
        }
        return carList;
    }

    public void moveCars() {
        for(RacingCar car : carList) {
            car.moveCar();
        }
    }

    public List<RacingCar> getCarList() {
        return carList;
    }

    public List<String> getMaxMoveCarsName() {

        List<String> maxMoveCarNameList = new ArrayList<>();
        for(RacingCar car : carList) {
            if(car.getMoveNumber() == getMaxMoveNumber()) {
                maxMoveCarNameList.add(car.getName());
            }
        }
        return maxMoveCarNameList;
    }

    private int getMaxMoveNumber() {
        List<Integer> moveNumberList = new ArrayList<>();
        for(RacingCar car : carList) {
            moveNumberList.add(car.getMoveNumber());
        }
        moveNumberList.sort(Collections.reverseOrder());
        return moveNumberList.get(0);
    }
}

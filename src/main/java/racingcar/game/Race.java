package racingcar.game;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Race {

    private final List<Car> carList;
    private final int trial;


    public Race(List<Car> carList, int trial) {
        this.carList = carList;
        this.trial = trial;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTrial() {
        return trial;
    }

    public void playMoveOrStop(){
        for(Car car : carList){
            if(car.randomSpeed() > 3){
                car.move();
            }
        }
    }

    private int getMaxposition(){
        List<Integer> maxPositionList = carList.stream().map(Car::getPosition).toList();
        return Collections.max(maxPositionList);
    }

    public String getCarNamesWithMaxPosition() {
        int maxPosition = getMaxposition();
        List<String> carNamesWithMaxPosition = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        if(carNamesWithMaxPosition.size() == 1){
            return carNamesWithMaxPosition.get(0);
        }else {
            return String.join(",", carNamesWithMaxPosition);
        }

    }


}

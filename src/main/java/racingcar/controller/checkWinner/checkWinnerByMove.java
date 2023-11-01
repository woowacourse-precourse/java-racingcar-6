package racingcar.controller.checkWinner;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class checkWinnerByMove implements CheckWinner{
    @Override
    public String[] getWinner(List<Car> carList) {
        List<String> nameList = new ArrayList<>();
        int max = getMaxMove(carList);
        for(Car car : carList){
            int carPosition = car.getPosition();
            if(max == carPosition) {
                nameList.add(car.getName());
            }
        }
        return nameList.toArray(new String[0]);
    }

    private int getMaxMove(List<Car> carList){
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}

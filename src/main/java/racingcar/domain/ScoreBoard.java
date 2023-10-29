package racingcar.domain;

import java.util.List;

public class ScoreBoard {

    public String getCarPosition(Car car) {
        String carPosition = "";
        for (int i = 0; i < car.carPosition; i++) {
            carPosition += "-";
        }
        return carPosition;
    }

    public void showCarsScore(List<Car> carList, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).tryMoveCar();
                System.out.println(carList.get(j).carName + " : " + getCarPosition(carList.get(j)));
            }
            System.out.println();
        }
    }
}

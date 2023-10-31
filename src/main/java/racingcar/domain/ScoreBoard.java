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

    public String showCarsScore(List<Car> carList, int tryNum) {
        String carsScore = "실행 결과\n";
        for (int i = 0; i < tryNum; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).tryMoveCar();
                carsScore += carList.get(j).carName + " : " + getCarPosition(carList.get(j)) + "\n";
            }
            carsScore += "\n";
        }
        return carsScore;
    }
}

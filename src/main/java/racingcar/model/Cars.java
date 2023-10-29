package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> carList;
    private static Cars instance;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars getInstance(List<Car> cars) {
        if(instance == null) {
            instance = new Cars(cars);
        }
        return instance;
    }

    public void racingCar() {
        for (Car car : carList) {
            car.dashByRandNum();
        }
    }

    public String getRacingResult() {
        StringBuilder racingResult = new StringBuilder();
        for (Car car : carList) {
            racingResult.append(car.getRacingResult()).append("\n");
        }
        return racingResult.toString();
    }

    public String getWinner() {
        String winners = "";
        for (Car car : carList) {
            if(car.getDashNum() == maxDash()) {
                winners += car.getWinnerName();
            }
        }
        return winners;
    }

    private int maxDash() {
        int maxDash = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.getDashNum() > maxDash) maxDash = car.getDashNum();
        }
        return maxDash;
    }
}

package model;

import java.util.List;

public class Winner {

    private int maxPosition = 0;

    public void getMaxPosition(List<Car> carList) {
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
    }

    public String getWinners(List<Car> carList) {
        getMaxPosition(carList);
        StringBuilder winner = new StringBuilder();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winner.append(car.getName()).append(", ");
            }
        }
        return winner.substring(0, winner.length() - 2);
    }

}

package racingcar.domain;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Car> carList;

    public CarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public ArrayList<String> move() {
        ArrayList<String> resultList = new ArrayList<>();
        for (Car car : carList) {
            String result = car.move();
            resultList.add(result);
        }
        return resultList;
    }

    public ArrayList<String> getWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        int winnerPosition = 0;

        for (Car car : carList) {
            winnerPosition = Integer.max(winnerPosition, car.getPosition());
        }
        for (Car car : carList) {
            if (winnerPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}

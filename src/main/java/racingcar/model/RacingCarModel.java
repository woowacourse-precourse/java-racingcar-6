package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RacingCarModel {
    private ArrayList<Car> carList;

    public RacingCarModel(Iterator<String> carNameListIterator) {
        carList = new ArrayList<>();

        while (carNameListIterator.hasNext()) {
            String carName = carNameListIterator.next();
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    public Iterator<String> getWinnerListIterator() {
        ArrayList<String> winnerList = new ArrayList<>();
        Collections.sort(carList);
        int maxMoveCount = carList.get(0).getMoveCount();

        for (Car car : carList) {
            if (car.getMoveCount() == maxMoveCount) {
                winnerList.add(car.getName());
            } else {
                break;
            }
        }

        return winnerList.iterator();
    }

    public Iterator<String> getRoundResultIterator() {
        ArrayList<String> roundResults = new ArrayList<>(carList.size());
        for (Car car : carList) {
            roundResults.add(car.toString());
        }
        return roundResults.iterator();
    }

    public void attemptMove() {
        for (Car car : carList) {
            car.attemptMove();
        }
    }

}

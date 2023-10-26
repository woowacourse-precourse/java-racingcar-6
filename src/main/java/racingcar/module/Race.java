package racingcar.module;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Race {
    ArrayList<Car> carList;

    public void addCar(Car car) {
        carList.add(car);
    }

    public ArrayList<String> getWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        int max = findFarthest();

        for (Car c : carList) {
            if (c.getPos() == max) {
                winnerList.add(c.getName());
            }
        }

        return winnerList;
    }

    int findFarthest() {
        Comparator<Car> compareByPose = Comparator.comparingInt(Car::getPos);
        return carList.stream().max(compareByPose).orElseThrow(NoSuchElementException::new).getPos();
    }
}

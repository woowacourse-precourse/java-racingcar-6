package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingService {

    private List<Car> carList = new ArrayList<>();

    public void startRacing() {
        createRacingCar();

        int count = getCount();

        while (count-- > 0) {
            moveAllRacingCar();
        }
    }

    private int getCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void createRacingCar() {
        String cars = Console.readLine();

        for (String car : cars.split(",")) {
            carList.add(new Car(car));
        }
    }

    private void moveAllRacingCar() {
        carList.stream().forEach(x -> x.moveWithRandomNumber());
    }


}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private List<Car> winCars = new ArrayList<>();

    public void judgeFinalResult(List<Car> cars) {

        longestDistance(cars);
        printWinner();
    }

    private void longestDistance(List<Car> cars) {

        winCars.add(cars.get(0));

        for (Car car : cars) {

            if (car.getCarDistance() > winCars.get(0).getCarDistance()) {

                winCars.clear();
                winCars.add(car);
            } else if (car.getCarDistance() == winCars.get(0).getCarDistance()) {

                winCars.add(car);
            }
        }
    }

    private void printWinner() {

        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winCars.size(); i++) {

            if (i == winCars.size() - 1) {

                System.out.print(winCars.get(i).getCarName());
                return;
            }

            System.out.print(winCars.get(i).getCarName() + ", ");
        }
    }
}

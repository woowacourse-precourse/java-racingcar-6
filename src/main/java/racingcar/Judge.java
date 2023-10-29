package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private List<String> winCars = new ArrayList<>();

    public void judgeResult(List<Car> cars) {

        String carName = null;

        for (int i = 0; i < cars.size() - 1; i++) {

            for (int j = i + 1; j < cars.size(); j++) {

                carName = longestDistance(cars.get(i), cars.get(j));
            }

            winCars.add(carName);
        }

        printWinner();
    }

    private String longestDistance(Car car1, Car car2) {

        if (car1.getCarDistance() >= car2.getCarDistance()) {

            return car1.getCarName();
        }

        return car2.getCarName();
    }

    private void printWinner() {

        System.out.print("최종 우승자 : ");

        for (String name : winCars) {

            System.out.print(name + ", ");
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {
    private final List<Car> cars;

    public CarController(String carNames) {
        this.cars = toList(carNames);
    }

    private List<Car> toList(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] name = carNames.split(",");
        for (String s : name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MOVE_NUMBER_MIN, Constants.MOVE_NUMBER_MAX);
            if (randomNumber >= Constants.MOVE_NUMBER_DEFAULT) {
                car.movePosition();
            }
        }

        printPositions();
    }

    private void printPositions() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }

            System.out.print("\n");
        }
    }

    public String getWinner() {
        // TODO: 임시 우승자 선정
        List<String> winner;
        winner = Arrays.asList("pobi", "jason");

        return String.join(",", winner);
    }
}

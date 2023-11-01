package racingcar;

import java.util.ArrayList;
import java.util.List;

public class raceWinner {

        public static List<String> getwinner(List<Car> cars) {
                List<String> winner = new ArrayList<>();
                int maxPosition = cars.stream()
                        .mapToInt(Car::carPosition)
                        .max()
                        .orElse(0);

                for (Car car : cars) {
                        if (car.carPosition() == maxPosition) {
                                winner.add(car.carNamePrint());
                        }        
                }

                return winner;
        }
}

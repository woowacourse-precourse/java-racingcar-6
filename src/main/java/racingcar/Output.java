package racingcar;

import java.util.List;

public class Output {
    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getCarName());
            stringBuilder.append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                stringBuilder.append("-");
            }
            System.out.println(stringBuilder.toString());
        });
    }
}

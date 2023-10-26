package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.CarGarage;

import java.util.List;

public class StringUtil {

    public String makeRaceResult(CarGarage garage) {
        StringBuilder sb = new StringBuilder();
        String format = "%s : %s";
        for (Car car : garage.cars()) {
            String formatted = String.format(format, car.getName(), "-".repeat(car.getPosition()));
            sb.append(formatted).append("\n");
        }
        return sb.toString();
    }

    public String makeWinnerResult(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        List<String> names = winner.stream()
                .map(Car::getName)
                .toList();
        sb.append(String.join(", ", names));
        return sb.toString();
    }
}

package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class StringUtil {

    public String makeRaceResult(Car car) {
        String format = "%s : %s";
        return String.format(format, car.getName(), "-".repeat(car.getPosition()));
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

package racingcar.util;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class StringUtil {
    public String makeResultMessage(RacingGame game) {
        StringBuilder sb = new StringBuilder();
        List<Car> cars = game.getCars();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            sb.append("-".repeat(Math.max(0, car.getDistance())));
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}

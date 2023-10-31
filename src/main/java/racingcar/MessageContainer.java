package racingcar;

import java.util.List;

public class MessageContainer {
    private static final String winnerIs = "최종 우승자 : ";

    public String showCarResult(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public String showWinners(List<String> winnerNames) {
        return winnerIs + String.join(", ", winnerNames);
    }
}



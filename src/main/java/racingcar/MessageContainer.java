package racingcar;

import java.util.List;

public class MessageContainer {
    private static final String enterCarNames = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String enterTotalRounds = "시도할 횟수는 몇회인가요?";
    private static final String winnerIs = "최종 우승자 : ";

    public String showCarResult(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public String showWinners(List<String> winnerNames) {
        return winnerIs + String.join(", ", winnerNames);
    }

    public String getEnterCarNames() {
        return enterCarNames;
    }

    public String getEnterTotalRounds() {
        return enterTotalRounds;
    }
}



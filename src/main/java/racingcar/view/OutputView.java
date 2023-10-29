package racingcar.view;

import java.util.Map;

public class OutputView {
    public void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printStartResult() {
        System.out.println("실행 결과");
    }

    public void printRacingStatus(Map<String, Integer> racingStatus) {
        StringBuilder racingStatusMessage = new StringBuilder();

        for (String carName : racingStatus.keySet()) {
            int countOfMove = racingStatus.get(carName);
            racingStatusMessage
                    .append(carName)
                    .append(":")
                    .append("-".repeat(countOfMove))
                    .append(System.lineSeparator());
        }
        System.out.println(racingStatusMessage);
    }
}
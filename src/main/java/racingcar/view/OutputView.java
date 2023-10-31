package racingcar.view;

import racingcar.enums.Common;
import racingcar.enums.CarType;
import racingcar.model.PlayResult;
import racingcar.model.PlayResults;
import racingcar.model.Winners;

public class OutputView {
    public static void printCarNameInputMessage() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)%n", Common.SEPARATOR.getStringValue());
    }

    public static void printNumberOfAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printPlayResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printPlayResult(PlayResults results) {
        for (PlayResult result : results.getResults()) {
            System.out.printf("%s : %s%n", result.get(CarType.CAR_NAME), result.get(CarType.DISTANCE));
        }
        System.out.println();
    }

    public static void printWinners(Winners winnerNames) {
        System.out.printf("최종 우승자 : %s", String.join(Common.SEPARATOR.getStringValue() + " ", winnerNames.getWinnerNames()));
    }
}

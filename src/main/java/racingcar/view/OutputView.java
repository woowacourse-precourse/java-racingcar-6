package racingcar.view;

import java.util.List;
import java.util.Map;

import racingcar.constants.Constants;
import racingcar.constants.MyEnum;

public class OutputView {
    public void printCarNameInputMessage() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)%n", Constants.SEPARATOR.getStringValue());
    }

    public void printNumberOfAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printPlayResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printPlayResult(List<Map<MyEnum, String>> results) {
        for (Map<MyEnum, String> result : results) {
            System.out.printf("%s : %s%n", result.get(MyEnum.CAR_NAME), result.get(MyEnum.DISTANCE));
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.printf("최종 우승자 : %s", winners);
    }
}

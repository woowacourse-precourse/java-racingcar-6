package racingcar.view;

import racingcar.handler.OutputHandler;

import java.util.List;
import java.util.Map;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printInputTryCountMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    @Override
    public void printGameResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printGameProgress(List<Map<String, String>> stageGameResults) {
        for (Map<String, String> stageGameResult : stageGameResults) {
            String carName = stageGameResult.get("carName");
            String position = stageGameResult.get("position");
            System.out.println(carName + " : " + position);
        }

        System.out.println();
    }

    @Override
    public void printFinalWinners(String winners) {
        System.out.printf("최종 우승자 : %s", winners);
    }
}

package racingcar.printer;

import java.util.List;
import racingcar.result.Result;

public class GamePrinter {

    public void printRacingCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberOfTimesMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(Result result, int round) {
        if (round == 0) {
            System.out.println("실행 결과");
        }

        System.out.println(result);
    }

    public void printWinnersName(List<String> winnersName) {
        System.out.println("최종 우승자 : " + String.join(", ", winnersName));
    }

    public void printNewLine() {
        System.out.println();
    }
}

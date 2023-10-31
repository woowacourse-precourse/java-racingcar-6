package racingcar.view;

import java.util.List;

public class RacingGameOutputView {
    public void print(String T) {
        System.out.printf("%s", T);
    }

    public void println(String T) {
        System.out.println(T);
    }

    public void printCarNameInputMessage() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRacingRoundInputMessage() {
        println("시도할 회수는 몇회인가요?");
    }
    public void printRacingResultAnnouncedMessage() { println("실행 결과");}

    public void printFinalWinnerAnnouncedMessage(List<String> winnerCarNames) {
        print("최종 우승자 : ");
        println(String.join(", ", winnerCarNames));
    }
}
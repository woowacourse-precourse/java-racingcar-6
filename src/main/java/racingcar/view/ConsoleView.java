package racingcar.view;

import racingcar.controller.GameController;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    public void printWelcomeMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printRaceResult(GameController race) {
        System.out.println("\n실행 결과");
        List<String> raceHistory = race.getRaceHistory();
        for (String roundResult : raceHistory) {
            System.out.println(roundResult);
        }

        System.out.println("\n최종 우승자: " + String.join(", ", race.getWinnersNames()));
    }
}

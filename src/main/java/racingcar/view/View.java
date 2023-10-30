package racingcar.view;

import static racingcar.domain.RacingCarGame.getGameWinner;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public static void startInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askForAttemptsCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static String input() {
        return Console.readLine();
    }

    public static void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void displayResult(List<StringBuilder> skeleton) { //
        for (StringBuilder sb : skeleton) {
            System.out.println(sb);
        }
    }

    public static void winnerMessage() {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", getGameWinner()));
    }
}

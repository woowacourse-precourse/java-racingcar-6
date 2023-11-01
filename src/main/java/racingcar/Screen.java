package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Screen {

    static public String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    static public String askRacingTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    static public void displayResultMessage() {
        System.out.println("\n실행 결과");
    }

    static public void displayResult(String result) {
        System.out.println(result);
    }

    static public void displayWinners(String winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners);
    }
}

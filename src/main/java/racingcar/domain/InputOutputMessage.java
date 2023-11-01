package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.Constants;

public class  InputOutputMessage {
    public static String carInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String roundInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void printStartMessage() {
        System.out.println(Constants.ROUND_RESULT);
    }

    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public static void presentWinner(ArrayList<String> winners) {
        System.out.println(Constants.WINNER_RESULT + String.join(Constants.COMMAS_AND_SPACE, winners));
    }

}

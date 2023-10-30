package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.Convert;

public class MainView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMP_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PROCEED_MESSAGE = "실행 결과";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }


    public static List<String> getCarNames() {
        String carNames = Console.readLine();
        return Convert.stringToListByComma(carNames);
    }

    public static void printInputAttemptMessage() {
        System.out.println(INPUT_ATTEMP_MESSAGE);
    }

    public static Integer getAttemptNumber() {
        String attemptNumber = Console.readLine();
        return Convert.stringToInteger(attemptNumber);
    }

    public static void printProceedResult(List<String> carNames, HashMap<String, Integer> racingStatus) {
        System.out.println(PROCEED_MESSAGE);
        for (String carName : carNames) {
            System.out.print(carName+" : ");
            printDash(racingStatus.get(carName));
        }
        System.out.println();
    }

    private static void printDash(Integer count) {
        for (int i = 0; i < count; ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerList) {
        String winnersMessageBuilder = "최종 우승자 : "
                + String.join(", ", winnerList);
        System.out.print(winnersMessageBuilder);
    }
}

package racingcar.view;

import static racingcar.domain.Controller.getgameWinner;
import static racingcar.model.Car.moveCount;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void startInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askForAttemptsCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static List<StringBuilder> displayResult(List<StringBuilder> result) {
        for (StringBuilder sb : result) {
            sb.append(moveCount());
            System.out.println(sb);
        }
        return result;
    }

    public static List<StringBuilder> createStringBuilders(List<String> carNameList) {
        List<StringBuilder> result = new ArrayList<>();

        for (String s : carNameList) {
            StringBuilder sb = new StringBuilder();
            sb.append(s).append(" : ");
            result.add(sb);
        }

        return result;
    }

    public static void winnerMessage() {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", getgameWinner()));
    }
}

package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static void printGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
    }
}

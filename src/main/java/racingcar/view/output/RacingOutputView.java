package racingcar.view.output;

import java.util.List;

public class RacingOutputView {

    private RacingOutputView() {
        throw new AssertionError("인스턴스화 불가능");
    }

    public static void outputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void outputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void outputResultMessage() {
        outputNextLine();
        System.out.println("실행 결과");
    }

    public static void outputRoundResults(List<String> roundResults) {
        roundResults.forEach(System.out::println);
        outputNextLine();
    }

    public static void outputNextLine() {
        System.out.println();
    }

    public static void outputWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

}

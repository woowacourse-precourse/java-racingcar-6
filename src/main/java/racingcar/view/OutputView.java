package racingcar.view;

public class OutputView {
    public static void carNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void tryNumberInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void racingResultMessage() {
        System.out.println("실행 결과");
    }

    public static void racingResult(String result) {
        System.out.println(result);
    }

    public static void winnerMessage(String message) {
        System.out.print("최종 우승자 : ");
        System.out.println(message);
    }
}

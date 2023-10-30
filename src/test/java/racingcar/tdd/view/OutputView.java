package racingcar.tdd.view;

public class OutputView {
    private static final String carNameInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String attemptCountInputMessage = "시도할 회수는 몇회인가요?";
    private static final String gameResultMessage = "실행 결과";

    public static void printCarNameInputMessage() {
        System.out.println(carNameInputMessage);
    }

    public static void printAttemptCountInputMessage() {
        System.out.println(attemptCountInputMessage);
    }

    public static void printGameResultMessage() {
        System.out.println(gameResultMessage);
    }

    public static void printRoundResult(String carName, int moveLength) {
        String moveStatus = "-";
        System.out.printf("%s : %s\n", carName, moveStatus.repeat(moveLength));
    }
}

package racingcar.views;

public class OutputView {
    public static void printCarNameInputInstruction() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTrialCountInstruction() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printFinalWinner(String[] winnerCarNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerCarNames));
    }
}

package racingcar.view;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    public static void printMove() {
        System.out.print("-");
    }

    public static void printNewLine() {
        System.out.println();
    }
}

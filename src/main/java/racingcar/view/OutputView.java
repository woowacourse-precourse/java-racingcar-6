package racingcar.view;


public class OutputView {
    public static void printResult() {
        System.out.println("\n실행 결과");
    }
    public static void printLineBreaking() {
        System.out.print("\n");
    }
    public static void printResultDetail(String carName, int goNumber) {
        System.out.print(carName+" : ");
        for (int i = 0; i < goNumber; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

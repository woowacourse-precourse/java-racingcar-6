package racingcar.view;

public class OutputView {
    public static void printResult() {
        System.out.println("실행 결과");
        // TODO: decide what will be the parameter that provides car names & position
    }

    private static void printCarNameAndPosition(String carName, int position) {
        printCarName(carName);
        printCarPosition(position);
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

package racingcar.view;

public class OutputView {

    public static void printRaceResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarPosition(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void divideRace() {
        System.out.println();
    }

}

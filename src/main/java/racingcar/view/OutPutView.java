package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutPutView {

    private static final int SOLO = 1;

    private OutPutView() {
    }

    public static void printResultMessage() {
        System.out.println(ViewMessage.OUTPUT_RESULT);
    }

    public static void printScore(List<Car> carList) {
        for (Car car : carList) {
            printCarScore(car);
        }
        System.out.println();
    }

    public static void printFinalWinner(List<String> winners) {
        System.out.println(ViewMessage.OUTPUT_FINAL_WINNER + winners.get(0));
        if (isSoloWin(winners)) {
            System.out.println();
            return;
        }
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i));
        }
        System.out.println();
    }

    private static boolean isSoloWin(List<String> winner) {
        return winner.size() == SOLO;
    }

    private static void printCarScore(Car car) {
        System.out.println(car.getName() + ViewMessage.OUTPUT_COLON);
        printCarPosition(car);
    }

    private static void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

}

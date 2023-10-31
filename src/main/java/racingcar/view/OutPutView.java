package racingcar.view;

import java.util.List;
import racingcar.dto.CarOutputRequestDto;

public class OutPutView {

    private static final int SOLO = 1;

    private OutPutView() {
    }

    public static void printResultMessage() {
        System.out.println(ViewMessage.OUTPUT_RESULT.getMessage());
    }

    public static void printScore(List<CarOutputRequestDto> carList) {
        for (CarOutputRequestDto car : carList) {
            System.out.print(car.getName() + ViewMessage.OUTPUT_COLON.getMessage());
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printFinalWinner(List<String> winners) {
        System.out.println(ViewMessage.OUTPUT_FINAL_WINNER.getMessage() + winners.get(0));
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

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}

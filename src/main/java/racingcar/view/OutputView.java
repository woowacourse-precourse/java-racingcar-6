package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.constants.Strings;

public class OutputView {

    public static void askCarName() {
        System.out.println(Strings.ASK_CAR_NAME.getMessage());
    }

    public static void askPlayTime() {
        System.out.println(Strings.ASK_PLAY_TIME.getMessage());
    }

    public static void showResultMessage() {
        System.out.println(Strings.RESULT.getMessage());
    }

    private static void printRacingCarDistance(RacingCar racingCar) {
        for (int j = 0; j < racingCar.getDistance(); j++) {
            System.out.print("-");
        }
    }

    public static void showCurrentDistance(RacingCars racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            System.out.print(racingCars.get(i).getName() + " : ");
            printRacingCarDistance(racingCars.get(i));
            System.out.println();
        }
        System.out.println();
    }

    public static void showFinalWinner(RacingCars winners) {
        System.out.print(Strings.FINAL_WINNER.getMessage());
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i + 1 < winners.size()) {
                System.out.print(", ");
            }
        }
    }


}

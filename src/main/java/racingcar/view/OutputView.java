package racingcar.view;

import racingcar.domain.RacingCars;
import racingcar.view.constants.Messages;

public class OutputView {

    public static void askCarName() {
        System.out.println(Messages.ASK_CAR_NAME.getMessage());
    }

    public static void askPlayTime() {
        System.out.println(Messages.ASK_PLAY_TIME.getMessage());
    }

    public static void showResultMessage() {
        System.out.println(Messages.RESULT.getMessage());
    }

    public static void showCurrentDistance(RacingCars racingcars) {

        for (int i = 0; i < racingcars.size(); i++) {
            System.out.print(racingcars.get(i).getName() + " : ");

            for (int j = 0; j < racingcars.get(i).getDistance(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showFinalWinner(RacingCars winners) {
        System.out.print(Messages.FINAL_WINNER.getMessage());
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i + 1 < winners.size()) {
                System.out.print(", ");
            }
        }
    }


}

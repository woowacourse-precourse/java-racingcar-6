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

    public static void showCurrentDistance(RacingCars racingcars) {
        System.out.println(Messages.RESULT.getMessage());
        for (int i = 0; i < racingcars.size(); i++) {
            System.out.print(racingcars.get(i).getName() + " : ");

            for (int j = 0; j < racingcars.get(i).getDistance(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void showFinalWinner(RacingCars winners) {
//        FINAL_WINNER("최종 우승자 : ");
    }


}

package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

public class OutputView {
    private static final String RACING_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String RACING_CAR_NAME = "%s : ";
    private static final String PROCEED = "-";
    private static final String DELIMITER = ",";

    public void printResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void printRacingResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printOneRacingCarResult(racingCar);
        }
        System.out.println();
    }

    private void printOneRacingCarResult(RacingCar racingCar) {
        // 자동차 이름
        String racingCarName = String.format(RACING_CAR_NAME, racingCar.getName());
        // 이동한 전체 칸
        String totalMove = PROCEED.repeat(racingCar.getMove());

        System.out.println(racingCarName + totalMove);
    }

    public void printWinners(List<String> winners) {
        String winnerList = String.join(DELIMITER, winners);
        System.out.println(String.format(WINNER_MESSAGE, winnerList));
    }
}

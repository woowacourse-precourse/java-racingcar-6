package racingcar.view;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingResult;
import racingcar.domain.RacingRoundResult;

public class RacingCarOutputView {
    public static final String RACING_EXECUTE_MESSAGE = "실행 결과";
    public static final String EACH_RACING_RESULT_FORMAT = "%s : %s";
    public static final String POSITION_PROGRESS = "-";
    public static final String DELIMITER = ", ";
    public static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    public void printStartMessage() {
        System.out.println(RACING_EXECUTE_MESSAGE);
    }

    public void printEachRacingResult(RacingResult racingResult) {
        List<RacingRoundResult> racingRoundResults = racingResult.getRacingRoundResults();
        for (RacingRoundResult r : racingRoundResults) {
            printCarsNameAndPosition(r);
        }
    }

    private void printCarsNameAndPosition(RacingRoundResult r) {
        List<Car> cars = r.getCars();
        for (Car car : cars) {
            String carName = car.getName();
            int position = car.getPosition();
            String positionProgress = convertPositionValue(position);
            String result = String.format(EACH_RACING_RESULT_FORMAT, carName, positionProgress);
            System.out.println(result);
        }
    }

    private String convertPositionValue(int position) {
        return POSITION_PROGRESS.repeat(position);
    }

    public void printWinner(RacingResult racingResult) {
        List<String> finalWinners = racingResult.getFinalWinners();
        String result = String.join(DELIMITER, finalWinners);
        System.out.println(FINAL_WINNERS_MESSAGE + result);
    }
}

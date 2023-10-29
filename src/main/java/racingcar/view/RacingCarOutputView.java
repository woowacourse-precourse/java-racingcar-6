package racingcar.view;


import java.util.List;
import racingcar.domain.RacingResult;
import racingcar.domain.RacingRoundResult;
import racingcar.dto.CarInfo;

public class RacingCarOutputView {
    public static final String RACING_EXECUTE_MESSAGE = "실행 결과";
    public static final String EACH_RACING_RESULT_FORMAT = "%s : %s";
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
        List<CarInfo> carInfoList = r.getCarInfoList();
        for (CarInfo carInfo : carInfoList) {
            String carName = carInfo.name();
            String positionProgress = carInfo.convertPositionValue();
            String result = String.format(EACH_RACING_RESULT_FORMAT, carName, positionProgress);
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinner(RacingResult racingResult) {
        List<String> finalWinners = racingResult.getFinalWinners();
        String result = String.join(DELIMITER, finalWinners);
        System.out.println(FINAL_WINNERS_MESSAGE + result);
    }
}

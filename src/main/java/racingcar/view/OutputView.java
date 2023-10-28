package racingcar.view;

import java.util.List;
import racingcar.dto.response.CarProgressDto;
import racingcar.dto.response.CarWinnersDto;
import racingcar.dto.response.RaceHistoryDto;
import racingcar.dto.response.RaceStageDto;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_PROGRESS_FORMAT = "%s : %s";
    private static final String POSITION_REPRESENTATION = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameResult(RaceHistoryDto raceHistoryDto) {
        System.out.println(GAME_RESULT_MESSAGE);
        List<RaceStageDto> raceStages = raceHistoryDto.getRaceStages();
        printRaceStages(raceStages);
    }

    private void printRaceStages(List<RaceStageDto> raceStages) {
        for (RaceStageDto currentRaceStage : raceStages) {
            List<CarProgressDto> carProgresses = currentRaceStage.getCarProgresses();
            printCarProgresses(carProgresses);
            printEmptyLine();
        }
    }

    private void printCarProgresses(List<CarProgressDto> carProgressDtos) {
        for (CarProgressDto currentCarProgress : carProgressDtos) {
            printCarProgress(currentCarProgress);
        }
    }

    private void printCarProgress(CarProgressDto carProgressDto) {
        String carProgress = formatCarProgress(carProgressDto);
        System.out.println(carProgress);
    }

    private String formatCarProgress(CarProgressDto carProgressDto) {
        String carName = carProgressDto.getCarName();
        int carPosition = carProgressDto.getPosition();
        return formatCarProgressIntoString(carName, carPosition);
    }

    private String formatCarProgressIntoString(String name, int position) {
        return String.format(CAR_PROGRESS_FORMAT, name, POSITION_REPRESENTATION.repeat(position));
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    public void printWinners(CarWinnersDto winnersDto) {
        List<String> winnerNames = winnersDto.getWinnerNames();
        String formattedWinnerNames = formatWinnersName(winnerNames);
        System.out.printf(WINNER_MESSAGE, formattedWinnerNames);
    }

    private String formatWinnersName(List<String> winnerNames) {
        return String.join(WINNER_NAME_DELIMITER, winnerNames);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}

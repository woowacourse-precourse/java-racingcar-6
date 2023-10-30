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

    public void printRaceHistory(RaceHistoryDto raceHistoryDto) {
        System.out.println(GAME_RESULT_MESSAGE);
        List<RaceStageDto> raceStageDtos = raceHistoryDto.getRaceStages();
        printRaceStages(raceStageDtos);
    }

    private void printRaceStages(List<RaceStageDto> raceStagesDts) {
        for (RaceStageDto currentRaceStageDto : raceStagesDts) {
            List<CarProgressDto> carProgressDtos = currentRaceStageDto.getCarProgresses();
            printCarProgresses(carProgressDtos);
            printEmptyLine();
        }
    }

    private void printCarProgresses(List<CarProgressDto> carProgressDtos) {
        for (CarProgressDto currentCarProgressDto : carProgressDtos) {
            printCarProgress(currentCarProgressDto);
        }
    }

    private void printCarProgress(CarProgressDto currentCarProgressDto) {
        String formattedCarProgress = formatCarProgress(currentCarProgressDto);
        System.out.println(formattedCarProgress);
    }

    private String formatCarProgress(CarProgressDto carProgress) {
        String carName = carProgress.getCarName();
        int carPosition = carProgress.getPosition();
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

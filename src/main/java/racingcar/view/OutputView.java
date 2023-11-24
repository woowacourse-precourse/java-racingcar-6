package racingcar.view;

import racingcar.dto.CarStatusDto;
import racingcar.dto.RaceResultDto;

import java.util.List;

import static racingcar.util.message.OutputMessage.*;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printInitCarStatus(List<CarStatusDto> initCarStatus) {
        StringBuilder initCarResult = new StringBuilder();
        initCarResult.append(RESULT_MESSAGE.getValue());
        initCarStatus
                .forEach(carStatusDto -> createCarStatus(carStatusDto, initCarResult));
        System.out.println(initCarResult);
    }

    public void printRaceResult(List<RaceResultDto> totalRaceResult) {
        StringBuilder raceResult = new StringBuilder();
        totalRaceResult
                .forEach(raceResultDto -> createTotalRaceResult(raceResultDto, raceResult));
        System.out.println(raceResult.toString().trim());
    }

    private void createTotalRaceResult(RaceResultDto raceResultDto, StringBuilder raceResult) {
        raceResultDto.getCarRaceResults()
                .forEach(carStatusDto -> createCarStatus(carStatusDto, raceResult));
        raceResult.append("\n");
    }

    private void createCarStatus(CarStatusDto carStatusDto, StringBuilder carStatus) {
        carStatus.append(carStatusDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carStatusDto.getCarPosition()))
                .append("\n");
    }

    public void printWinnersResult(List<String> winners) {
        System.out.println("\n" + WINNER_MESSAGE.getValue() + String.join(WINNER_DELIMITER.getValue(), winners));
    }
}

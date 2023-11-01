package racingcar.view;

import java.util.List;

import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;

import static racingcar.enumType.OutputMessage.*;

public class OutputView {
    
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printInitCarStatus(List<CarStatusDto> initCarStatus) {
        StringBuilder intitCarResult = new StringBuilder();
        intitCarResult.append(RESULT_MESSAGE.getValue());
        initCarStatus
            .forEach(carStatusDto -> createCarStatus(carStatusDto, intitCarResult));
        System.out.println(intitCarResult);
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
        carStatus.append(carStatusDto.getName())
            .append(NAME_POSITION_DELIMITER.getValue())
            .append(RACE_MARK.getValue().repeat(carStatusDto.getCarPosition()))
            .append("\n");
    }

    public void printWinnerResult(List<String> winners) {
        System.out.println(WINNER_MESSAGE.getValue() + String.join(WINNER_DELIMITER.getValue(), winners));
    }
}

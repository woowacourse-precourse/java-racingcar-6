package racingcar.view;


import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;

public class RacingCarOutputView {
    private static final String RACING_EXECUTE_MESSAGE = "실행 결과";
    private static final String EACH_RACING_RESULT_FORMAT = "%s : %s";
    private static final String DELIMITER = ", ";
    private static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    public void printStartMessage() {
        System.out.println(RACING_EXECUTE_MESSAGE);
    }

    public void printEachRacingResult(RacingRoundResultDto racingRoundResultDto) {
        List<CarDto> carDtos = racingRoundResultDto.carDtos();
        for (CarDto carDto : carDtos) {
            String carName = carDto.name();
            String positionProgress = carDto.convertPositionValue();
            String result = String.format(EACH_RACING_RESULT_FORMAT, carName, positionProgress);
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinner(RacingResultDto racingResultDto) {
        List<String> finalWinners = racingResultDto.carNames();
        String result = String.join(DELIMITER, finalWinners);
        System.out.println(FINAL_WINNERS_MESSAGE + result);
    }
}

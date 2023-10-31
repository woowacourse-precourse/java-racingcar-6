package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.ResultDto;
import racingcar.domain.SingleRoundResultDto;
import racingcar.util.Sentence;

import java.math.BigInteger;

public class OutputView {

    public void beforeInputCarNames() {
        System.out.println(Sentence.INPUT_CAR_NAMES.getMessage());
    }

    public void beforeInputTryNumber() {
        System.out.println(Sentence.INPUT_TRY_NUMBERS.getMessage());
    }

    public void printResult(ResultDto resultDto) {
        printRacingDistanceResults(resultDto);
    }

    private void printRacingDistanceResults(ResultDto resultDto) {
        System.out.print(Sentence.ALIGN_LINE.getMessage());
        System.out.println(Sentence.RESULT_START_MENTION.getMessage());

        long round = 1L;
        long finalRound = resultDto
                .getFinalRound()
                .longValue();
        while (round != finalRound) {
            SingleRoundResultDto singleRoundResultDto = resultDto
                    .getSingleRoundResultDto(BigInteger.valueOf(round));
            long carNumbers = singleRoundResultDto.getCarNumbers();
            for (int index = 0; index < carNumbers; index++) {
                Car.CarResultDto carResult = singleRoundResultDto
                        .getCarResultDto(index);
                System.out.println(carResult);
            }
            round ++;
            System.out.print(Sentence.ALIGN_LINE.getMessage());
        }
    }
}

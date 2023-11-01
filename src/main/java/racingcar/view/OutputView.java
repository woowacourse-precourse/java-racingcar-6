package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.ResultDto;
import racingcar.domain.SingleRoundResultDto;
import racingcar.util.Consts;
import racingcar.util.Sentence;

import java.math.BigInteger;
import java.util.List;

public class OutputView {

    public void beforeInputCarNames() {
        System.out.println(Sentence.INPUT_CAR_NAMES.getMessage());
    }

    public void beforeInputTryNumber() {
        System.out.println(Sentence.INPUT_TRY_NUMBERS.getMessage());
    }

    public void printResult(ResultDto resultDto) {
        printRacingDistanceResults(resultDto);
        printFinalWinners(resultDto);
    }

    private void printRacingDistanceResults(ResultDto resultDto) {
        System.out.print(Sentence.ALIGN_LINE.getMessage());
        System.out.println(Sentence.RESULT_START_MENTION.getMessage());

        long round = Consts.FIRST_ROUND;
        long finalRound = resultDto
                .getFinalRound()
                .longValue();

        while (round <= finalRound) {
            SingleRoundResultDto singleRoundResultDto = resultDto
                    .getSingleRoundResultDto(BigInteger.valueOf(round));
            long carNumbers = singleRoundResultDto.getCarNumbers();
            for (int index = 0; index < carNumbers; index++) {
                Car.CarResultDto carResult = singleRoundResultDto.getCarResultDto(index);
                System.out.println(carResult);
            }
            round ++;
            System.out.print(Sentence.ALIGN_LINE.getMessage());
        }
    }

    private void printFinalWinners(ResultDto resultDto) {
        List<String> finalWinners = resultDto.getFinalWinners();
        StringBuilder finalWinnersStringBuilder =
                new StringBuilder(Sentence.FINAL_WINNER.getMessage());

        finalWinnersStringBuilder.append(Sentence.COLON_FOR_LIST.getMessage());

        appendWinners(finalWinners, finalWinnersStringBuilder);

        System.out.println(finalWinnersStringBuilder);
    }

    private static void appendWinners(List<String> finalWinners, StringBuilder finalWinnersStringBuilder) {
        int finalWinnerNumber = finalWinners.size();
        for (int i = 0; i < finalWinnerNumber; i++) {
            finalWinnersStringBuilder.append(finalWinners.get(i));
            if (checkNotLastWinner(finalWinnerNumber, i)) {
                finalWinnersStringBuilder.append(Sentence.COMMA_FOR_LIST.getMessage());
            }
        }
    }

    private static boolean checkNotLastWinner(int finalWinnerNumber, int i) {
        return i < finalWinnerNumber - 1;
    }

}

package racingcar.view;

import racingcar.domain.dto.output.CarDto;
import racingcar.domain.dto.output.CarsDto;
import racingcar.domain.dto.output.WinnerDto;
import racingcar.domain.dto.output.WinnersDto;
import racingcar.io.Writer;

import java.util.List;

public class OutputView {
    private static final String DASH = "-";
    private static final String DELIMITER = ", ";
    private static final String GAME_RESULT = "\n실행 결과";
    private static final String WINNER_RESULT = "최종 우승자 : ";
    private final Writer writer;
    private boolean isFirstRound = true;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    private static List<String> getWinnerNames(WinnersDto winnersDto) {
        return winnersDto.winners()
                .stream()
                .map(WinnerDto::name)
                .toList();
    }

    public void printGameResult(CarsDto carsDto) {
        printGameResultMsgOnlyIfFirstRound();
        List<CarDto> carDtoList = carsDto.carDtoList();
        for (CarDto carDto : carDtoList) {
            getRoundResultOf(carDto);
        }
        System.out.println();
    }

    public void printWinner(WinnersDto winnersDto) {
        writer.write(WINNER_RESULT);
        List<String> winnerNames = getWinnerNames(winnersDto);
        System.out.println(String.join(DELIMITER, winnerNames));
    }

    private void getRoundResultOf(CarDto carDto) {
        String carGameResult = String.format("%s : %s",
                carDto.name(),
                convertToDashes(carDto.position()));
        System.out.println(carGameResult);
    }

    private void printGameResultMsgOnlyIfFirstRound() {
        if (isFirstRound) {
            writer.writeln(GAME_RESULT);
            isFirstRound = false;
        }
    }

    private String convertToDashes(int position) {
        return DASH.repeat(Math.max(0, position));
    }
}

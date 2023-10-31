package racingcar.view;

import racingcar.domain.dto.output.CarDto;
import racingcar.domain.dto.output.CarsDto;
import racingcar.domain.dto.output.WinnersDto;
import racingcar.io.OutputWriter;

import java.util.List;

public class OutputView {
    private static final String DASH = "-";
    private final OutputWriter writer;
    private boolean isFirstRound = true;

    public OutputView(OutputWriter writer) {
        this.writer = writer;
    }


    public void printGameResult(CarsDto carsDto) {
        printGameResultMsgOnlyIfFirstRound();
        List<CarDto> carDtoList = carsDto.carDtoList();
        for (CarDto carDto : carDtoList) {
            String carGameResult = String.format("%s : %s",
                    carDto.name(),
                    convertToDashes(carDto.position()));
            System.out.println(carGameResult);
        }
        System.out.println();
    }

    private void printGameResultMsgOnlyIfFirstRound() {
        if (isFirstRound) {
            writer.writeGameResultMsg();
            isFirstRound = false;
        }
    }

    private String convertToDashes(int position) {
        return DASH.repeat(Math.max(0, position));
    }

    public void printWinner(WinnersDto winnersDto) {
        writer.writeGameWinnerMsg();
        System.out.println(String.join(", ", winnersDto.winnerList()));
    }
}

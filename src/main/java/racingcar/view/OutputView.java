package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public interface OutputView {

    void printPlayMessage();

    void printResult(List<CarDto> carDtos);

    void printFinalWinners(List<String> winnerNames);
}

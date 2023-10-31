package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public interface OutputViewable {

    void printPlayMessage();

    void printResult(List<CarDto> carDtos);

    void printFinalWinners(List<String> winnerNames);
}

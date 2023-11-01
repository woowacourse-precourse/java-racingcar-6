package racingcar.controller;

import racingcar.dto.output.ResultOfGameDto;
import racingcar.dto.output.ResultOfTurnDto;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

import java.util.List;

import static racingcar.dto.output.ResultOfGameDto.createWinnersOfGame;

public class RacingCarController {
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }
    private void showAdvancecProgress(ResultOfTurnDto resultOfTurnDto) {
        racingCarView.printRacingCarName(resultOfTurnDto);
        racingCarView.printColon();
        racingCarView.printAdvanceMark(resultOfTurnDto);
    }
    private void showWinners(ResultOfGameDto resultOfGameDto) {
        racingCarView.printWinners(resultOfGameDto);        // 최종 우승자 출력
    }
    private ResultOfGameDto determineWinners(final RacingCars racingCars) {
        List<RacingCar> cars = racingCars.getRacingWinners();
        List<String> winners = racingCars.listRacingCarToListString(cars);
        ResultOfGameDto resultOfGameDto = createWinnersOfGame(winners);
        return resultOfGameDto;
    }
}

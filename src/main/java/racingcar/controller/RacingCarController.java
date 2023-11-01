package racingcar.controller;

import racingcar.dto.input.NumberOfAttemptsDto;
import racingcar.dto.input.RacingCarsDto;
import racingcar.dto.output.ResultOfGameDto;
import racingcar.dto.output.ResultOfTurnDto;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

import java.util.List;

import static racingcar.dto.output.ResultOfGameDto.createWinnersOfGame;
import static racingcar.dto.output.ResultOfTurnDto.createAdvancecProgress;

public class RacingCarController {
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }
    public void racingStart() {
        RacingCarsDto racingCarsDto = racingCarView.inputCarName();
        NumberOfAttemptsDto numberOfAttemptsDto = racingCarView.inputNumberOfAttempts();
        racingCarView.printResultMessage();         // print("실행 결과")
        RacingCars racingCars = racingCarsDto.toRacingCars();
        for (int i = 0; i < numberOfAttemptsDto.toInteger(); i++) {
            runRaceTurn(racingCars);        // 레이스 턴별로 진행
        }
        ResultOfGameDto winners = determineWinners(racingCars);     // 우승자 가리기
        showWinners(winners);   // 최종 우승자 출력
    }
    private void runRaceTurn(final RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {  // getter 안쓸수 있는 방향으로 리팩토
            if (racingCar.canAdvance()) {
                racingCar.advance();
            }
            ResultOfTurnDto resultOfTurnDto = createAdvancecProgress(racingCar);
            showAdvancecProgress(resultOfTurnDto);
        }
        racingCarView.printSpaceLine();
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

package racingcar.controller;

import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.domain.game.car.Cars;
import racingcar.util.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public GameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        // 1. 자동차 이름 입력 받기
        Cars cars = inputView.getCarsFromUserInput();
        // 2. 총 라운드 수 입력 받기
        int trial = inputView.getTrialFromUserInput();
        // 3. 총 라운드 수 만큼 반복 == (1게임 - 실행 - 출력) x 총 라운드 수
        WinnersDto winnersDto = playGame(trial, cars);
        //마지막 CarsDto로 최종 우승자 출력
        outputView.printGameWinner(winnersDto);
    }

    private WinnersDto playGame(int trial, Cars cars) {
        for (int i = 1; i <= trial; i++) {
            // 모든 자동차는 전진 조건에 따라 움직이고, 게임 결과인 CarsDto를 반환
            CarsMovementDto carsMovementDto = cars.moveOnce(moveStrategy);
            // view의 인자로 CarsDto를 전달하고, 출력
            outputView.printGameResult(carsMovementDto);
        }
        return cars.toWinnerDto();
    }
}

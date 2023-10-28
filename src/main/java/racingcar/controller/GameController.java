package racingcar.controller;

import racingcar.domain.dto.CarsDto;
import racingcar.domain.game.Cars;
import racingcar.util.NumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberPicker numberPicker;

    public GameController(InputView inputView, OutputView outputView, NumberPicker numberPicker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberPicker = numberPicker;
    }

    public void run() {
        // 1. 자동차 이름 입력 받기
        Cars cars = inputView.getCarsFromUserInput();
        // 2. 총 라운드 수 입력 받기
        int allRound = inputView.getAllRoundFromUserInput();
        // 3. 총 라운드 수 만큼 반복 == (1게임 - 실행 - 출력) x 총 라운드 수
        outputView.printAllRoundMessage();
        for (int i = 1; i <= allRound; i++) {
            // - 모든 자동차는 전진 조건에 따라 움직이고, 게임 결과인 CarsDto를 반환
            CarsDto carsDto = cars.moveOnce(numberPicker);
            // - view의 인자로 CarsDto를 전달하고, 출력
            outputView.printGameResult(carsDto);
            // - 마지막 CarsDto로 최종 우승자 출력
            if (i == allRound) {
                outputView.printGameWinner(carsDto);
            }
        }
    }
}

package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameRound;
import racingcar.domain.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    private final MovingStrategy movingStrategy;


    public GameController(InputView inputView , OutputView outputView, MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }


    public void play() {
        Cars cars = createCars();

        // 게임 라운드 회수 입력 받기


        // 각 라운드 별 결과 출력

        // 최종 우승자 출력
    }

    private Cars createCars() {
        // 경주 할 자동차 이름 입력 받기
        List<String> names = inputView.inputNames();
        Cars cars = new Cars(names, movingStrategy);

        return cars;
    }


}

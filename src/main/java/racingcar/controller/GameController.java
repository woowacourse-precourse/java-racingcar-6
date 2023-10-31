package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;
import racingcar.domain.MovingStrategy;
import racingcar.util.RandomNumberUtil;
import racingcar.util.RandomNumberUtilImp;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;
    private final Cars cars;
    private RaceRound raceRound;


    public GameController(
            final InputView inputView,
            final OutputView outputView,
            final MovingStrategy movingStrategy,
            final Cars cars) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
        this.cars = cars;
    }

    // 프로그램 전체 흐름을 파악할 수 있는 형식으로 작성하기
    public void play() {
        // Cars 생성
        // 게임 라운드 받기
        // 게임 라운드 만큼 실행
        // 결과 찾기 및 출력
    }


}

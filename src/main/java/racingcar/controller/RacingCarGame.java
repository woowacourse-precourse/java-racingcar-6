package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Dice;
import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final InputView inputView;
    private final RacingCarGameService racingCarGameService;

    public RacingCarGame() {
        this.inputView = new InputView();
        this.racingCarGameService = new RacingCarGameService();
    }

    public void run(){

    }

}

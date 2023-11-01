package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.UserInputRoundNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingGame {
    private static int roundRepeatNum;
    private Cars cars;
    private UserInputRoundNumber userInputRoundNumber;
    private LinkedHashMap<String, Integer> forwardState = new LinkedHashMap<>();
    private String userRoundNum;

    public void game() {
        setPlay();
        play();
        rewardMVP();
    }

    private void setPlay() {
        userInputRoundNumber = new UserInputRoundNumber();
        cars = new Cars(InputView.createCarName());
        userRoundNum = InputView.createRoundNumber();
        roundRepeatNum = userInputRoundNumber.createRoundNumber(userRoundNum);
    }

    private void play() {
        OutputView.printResult();
        for (int i = 0; i < roundRepeatNum; i++) {
            cars.depart();
            getForwardState();
        }
    }

    private void rewardMVP() {
        List<String> mvp = Cars.getMVP();
        OutputView.printMVP(mvp);
    }

    private void getForwardState() {
        forwardState = Cars.getForwardState();
        OutputView.printForward(forwardState);
    }
}



package racingcar.controller;


import racingcar.domain.Cars;
import racingcar.util.RandomNumber;
import racingcar.domain.UserInputRoundNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private Cars cars;
    private UserInputRoundNumber userInputRoundNumber;
    private LinkedHashMap<String, Integer> forwardState = new LinkedHashMap<>();
    private String userRoundNum;
    private static int roundRepeatNum;

    public void game(){
        setPlay();
        play();
        rewardMVP();
    }
    private void setPlay(){
        cars = new Cars(InputView.createCarName());
        userRoundNum = InputView.createRoundNumber();
        roundRepeatNum = UserInputRoundNumber.stringToInt(userRoundNum); // 라운드 반복 횟수
    }

    private void play(){
        OutputView.printResult();
        for(int i = 0; i < roundRepeatNum; i++) {
            cars.depart();
            getForwardState();
        }
    }

    private void rewardMVP(){
        List<String> mvp = cars.getMVP();
        OutputView.printMVP(mvp);
    }

    private void getForwardState() {
        forwardState = cars.getForwardState();
        OutputView.printForward(forwardState);
        }
    }



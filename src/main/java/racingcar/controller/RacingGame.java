package racingcar.controller;


import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;
import racingcar.domain.UserInputRoundNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private InputView inputView;
    private OutputView outputView;
    private Cars cars;
    private UserInputRoundNumber userInputRoundNumber;
    private Map<String, Integer> forwardState = new HashMap<>();


    public void game(){
        setPlay();
        play();
        rewardMVP();
    }
    private int setPlay(){
        String userInput = InputView.createCarName();
        Cars cars = new Cars(userInput);
        String userRoundNum = InputView.createRoundNumber();
        int roundRepeatNum = UserInputRoundNumber.stringToInt(userRoundNum); // 라운드 반복 횟수
        return roundRepeatNum;
    }

    private void play(){
        RandomNumber randomNumber = new RandomNumber();
        int random = randomNumber.createRandomNumber();
        int repeatNum = setPlay();
        for(int i = 0; i < repeatNum; i++) {
            cars.depart(random);
            getForwardState();
        }
    }

    private void rewardMVP(){
        List<String> mvp = cars.getMVP();
        outputView.printMVP(mvp);
    }

    private void getForwardState() {
        forwardState = cars.getForwardState();
        for (Map.Entry<String, Integer> entry : forwardState.entrySet()) {
            outputView.printForward(entry.getKey(), entry.getValue());
        }
    }



}

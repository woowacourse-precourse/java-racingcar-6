package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final InputView inputView;
    private final OutputView outputView;
    public RaceGame(){
        cars = new ArrayList<>();
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void run(){
        playGame();
        endGame();
    }
    private void playGame(){
        inputView.inputName(cars);
        Integer moveCount = inputView.inputMoveCount();
        System.out.println("실행 결과");
        for(int i = 0;i < moveCount;i++){
            for(Car car : cars){
                car.move();
            }
            outputView.printCarsPosition(cars);
        }
    }

    private void endGame(){
        outputView.printWinner(cars);
    }
}

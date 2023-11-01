package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    private InputController input;
    private Cars cars;
    private int playNum;

    public GameController(){
        input = new InputController();
        cars = input.setName();
        playNum = input.setNum();
        run();
    }
    public void run(){
        OutputView.printResult();
        IntStream.range(0, playNum).forEach(i -> cars.play());
        cars.searchWinner();
    }




}

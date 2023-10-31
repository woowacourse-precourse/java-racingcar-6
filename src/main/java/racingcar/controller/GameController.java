package racingcar.controller;

import racingcar.model.Cars;
import racingcar.validator.NameValidator;
import racingcar.validator.NumValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    private InputController input;
    private Cars cars;
    private int playNum;

    public GameController(){
        input = new InputController();
        set();
        run();
    }
    public void set(){
        cars = input.setName();
        playNum = input.setNum();
    }
    public void run(){
        OutputView.printResult();
        IntStream.range(0, playNum).forEach(i -> cars.roundPlay());
        cars.searchWinner();
    }




}

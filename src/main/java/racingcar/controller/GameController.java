package racingcar.controller;

import racingcar.model.Cars;
import racingcar.validator.NameValidator;
import racingcar.validator.NumValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    private InputView input;
    private Cars cars;
    private int playNum;

    public GameController(){
        input = new InputView();
        setName();
        setNum();
    }

    public void setName(){
        try{
            NameValidator nameCheck = new NameValidator(input.inputPlayer());
            new Cars(nameCheck.NAMES);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public void setNum(){
        try{
            NumValidator numCheck = new NumValidator(input.inputNum());
            playNum = Integer.parseInt(numCheck.NUM);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void run(){
        OutputView.printResult();
        IntStream.range(0, playNum).forEach(i -> cars.roundPlay());


    }



}

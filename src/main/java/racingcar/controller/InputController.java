package racingcar.controller;

import racingcar.model.Cars;
import racingcar.validator.NameValidator;
import racingcar.validator.NumValidator;
import racingcar.view.InputView;
import java.util.ArrayList;


public class InputController {
    private InputView input;
    private int playNum;
    public InputController(){
        input = new InputView();
    }
    public Cars setName(){
        try{
            new NameValidator(input.inputPlayer());
            return new Cars(NameValidator.NAMES);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public int setNum(){
        new NumValidator(input.inputNum());
        playNum = Integer.parseInt(NumValidator.NUM);
        return playNum;
    }
}

package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private String carNames;
    private String turns;
    private final Validator validator;

    public UserInput(){
        this.carNames = "";
        this.turns = "";
        this.validator = new Validator();
    }

    public void inputCarNames(){
        String newCarNames = Console.readLine();
        validator.validateCarNames(newCarNames);
        this.carNames = newCarNames;
    }

    public void inputTurns(){
        String newTurns = Console.readLine();
        validator.validateTurns(newTurns);
        this.turns = newTurns;
    }

    public String getCarNames(){
        return this.carNames;
    }

    public String getTurns(){
        return  this.turns;
    }
}

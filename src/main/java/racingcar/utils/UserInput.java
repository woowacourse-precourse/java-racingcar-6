package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private String carNames;
    private String turns;
    // TODO : validator 추가

    public UserInput(){
        this.carNames = "";
        this.turns = "";
    }

    public void inputCarNames(){
        String newCarNames = Console.readLine();
        // TODO : newCarsName 검증하기
        this.carNames = newCarNames;
    }

    public void inputTurns(){
        String newTurns = Console.readLine();
        // TODO : newTurns 검증하기
        this.carNames = newTurns;
    }

    public String getCarNames(){
        return this.carNames;
    }

    public String getTurns(){
        return  this.turns;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class RacingGame {
    private ArrayList<Car> carList = new ArrayList<>();
    private int gameNumber;

    public RacingGame(){
        InputValue inputValue = new InputValue();
        carList = inputValue.getCarsName();
        gameNumber = inputValue.getGameNumber();
    }
    
}


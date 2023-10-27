package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Dice {

    private static final int MIN_DICE_NUMBER = 0;
    private static final int MAX_DICE_NUMBER = 9;
    private static Dice dice = null;

    private Dice() {
    }

    public static Dice getInstance(){
        if(dice == null){
            dice = new Dice();
        }
        return dice;
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

}

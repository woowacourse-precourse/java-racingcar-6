package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {

    private Integer randomNumber;

    public Integer getRandomNumber() {
        drawRandomNumber();
        return randomNumber;
    }

    private void drawRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(0,9);
    }
}

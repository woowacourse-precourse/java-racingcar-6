package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int place = 0;
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
    public void addPlace(){
        place++;
    }
}

package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int INITIAL_DISTANCE = 0;
    private final int MOVABLE_NUMBER = 0;
    private final int MIN_RANDOM_NUMBER = 1;
    private final int MAX_RANDOM_NUMBER = 9;

    private final Name name;
    private int position = INITIAL_DISTANCE;

    public Car(String name){
        this.name = new Name(name);
    }

    public void move(){
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER + 1) >= MOVABLE_NUMBER){
            position++;
        }
    }
}

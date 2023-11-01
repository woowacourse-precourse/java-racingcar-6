package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.variables.Variables;

public class Car {
    public Car(String name) {
        this.name = name;
    }

    private int coord = 0;
    private final String name;

    private int generateRandNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    private boolean isBiggerThanExpected(){
        return generateRandNum() >= Variables.RAND_NUM_EXPECT.getValue();
    }
    public void tryMovingForword(){
        if (isBiggerThanExpected())
            this.coord++;
    }


    // Car 객체의 toString 구현 "($this.name) : ($this.coord)* - "
    // Example : "pobi : --"
    @Override
    public String toString(){
        return this.name + " : "
                + "-".repeat(this.coord);
    }

    public String getName() {
        return this.name;
    }

    public int getCoord() {
        return this.coord;
    }
}

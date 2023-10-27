package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int position;

    public Car(final String carName) {
        this.carName = carName;
        this.position = 0;
    }

    private void selectMove() {
        Integer randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >= 4){
            position++;
        }
    }

}

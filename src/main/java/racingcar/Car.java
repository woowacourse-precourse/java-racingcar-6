package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private Integer position;

    public Car(final String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName(){
        return this.carName;
    }

    public Integer getPosition() {
        return this.position;
    }

    public boolean isWinner(Integer maxPosition) {
        return position == maxPosition;
    }

    public void selectMove() {
        Integer randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >= 4){
            position++;
        }
    }

}

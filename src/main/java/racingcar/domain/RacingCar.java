package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lombok.Getter;

public class RacingCar {
    @Getter
    private String carName;
    private int score = 0;

    public RacingCar(String name){
        this.carName = name;
        this.score = 0;
    }
    public String getCarName() {
        return carName;
    }
    private void moveCar(){
        this.score++;
    }

    public int getScore() {
        return score;
    }

    public void checkMove(){
        if(Randoms.pickNumberInRange(0,9) >3){
            moveCar();
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carName;
    private String result = "";
    public void carMoveOrStop() {
        if (isMoveAble()) {
            result += "-";
        }
    }
    public void giveNameOfCar(String carName) {
            this.carName = carName;
    }
    public String printMovingCarWithCarName() {
        return carName + " : " + result + "\n";
    }

    public boolean isMoveAble() {
        return generateRandomNumber() > 3;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}

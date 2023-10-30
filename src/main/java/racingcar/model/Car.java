package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int driveCount;

    public Car(String carName) {
        this.carName = carName;
        this.driveCount = 0;
    }

    public void decideDrive() {
        int driveCheck = Randoms.pickNumberInRange(0,9);
        if (driveCheck >= 4)
            driveCount += 1;
    }
    
}

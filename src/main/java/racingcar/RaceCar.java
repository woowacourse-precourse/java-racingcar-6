package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceCar {
    private final String carName;
    private int go;

    public RaceCar(String carName) {
        this.carName = carName;
        this.go = 0;
    }

    public int getDistance() {
        return go;
    }

    public String getName() {
        return carName;
    }

    public void run() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        // 4이상 움직임 일때 전진
        if (randomNumber >= 4) {
            this.go += 1;
        }
    }
}
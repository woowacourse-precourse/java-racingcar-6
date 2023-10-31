package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private String name;
    private String distance = "";
    private boolean canGo;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return this.distance;
    }

    private void determineCanGo() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        this.canGo = randomNumber >= 4;
    }

    private void updateDistance() {
        if (this.canGo) {
            this.distance += "-";
        }
    }
}

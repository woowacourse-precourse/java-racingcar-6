package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    String name;
    int step;

    public RacingCar(String name) {
        this.name = name;
        this.step = 0;
    }

    public void moveForward() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            this.step++;
        }
        printCurrentPosition();
    }

    private void printCurrentPosition(){
        System.out.println(name + " : " + "-".repeat(this.step));
    }
}

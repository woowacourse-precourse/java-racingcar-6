package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private String name;
    private String distance = "";
    private boolean canGo;

    private void determineCanGo() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        this.canGo = randomNumber >= 4;
    }
}

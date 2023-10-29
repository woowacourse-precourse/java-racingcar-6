package racingcar.game.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private final StringBuilder forwardState;

    private Car(String name) {
        this.name = name;
        this.forwardState = new StringBuilder();
    }

    public static Car create(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름이 5자 이하가 아닙니다.");
        }

        return new Car(name);
    }

    public void tryForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) forwardState.append('-');
    }

    public String getCarState() {
        return name + " : " + forwardState;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getForwardState() {
        return forwardState;
    }

}

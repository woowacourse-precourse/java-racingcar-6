package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Long distance;

    public Car(String name) {
        this.name = name;
        distance = 0L;
    }

    public void moveOrStay() {
        int decisionNumber = Randoms.pickNumberInRange(0, 9);

        if (decisionNumber >= 4) {
            distance++;
        }
    }

    public String printResult() {
        StringBuilder hyphen = new StringBuilder();

        for (long i = 0; i < distance; i++) {
            hyphen.append("-");
        }

        return name + " : " + hyphen.toString();
    }
}
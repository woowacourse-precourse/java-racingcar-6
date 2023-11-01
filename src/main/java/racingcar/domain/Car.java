package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void showDistance() {
        StringBuilder runResult = new StringBuilder();
        runResult.append(name);
        runResult.append(" : ");
        for (int i = 0; i < position; i++) {
            runResult.append("-");
        }
        System.out.println(runResult.toString());
    }
}

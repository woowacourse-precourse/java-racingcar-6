package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private final StringBuffer report;

    public Car(String name) {
        this.name = name;
        this.report = new StringBuffer();
        this.report.append(name);
        this.report.append(" : ");
    }

}

package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int NAME_STANDARD = 5;
    private static final int RUN_STANDARD = 4;
    private final String name;
    private String location = "";

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    void validateName(String name) {
        if (name.length() > NAME_STANDARD) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void run() {
        boolean runCondition = isRunCondition();
        if (runCondition) {
            this.location += "-";
        }
        System.out.println(this.getName() + " : " + this.getLocation());
    }

    boolean isRunCondition() {
        boolean runCondition = Randoms.pickNumberInRange(0,9) >= RUN_STANDARD;
        return runCondition;
    }
}

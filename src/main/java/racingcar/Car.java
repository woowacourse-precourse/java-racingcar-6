package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Name is too long");
        }
        if (name.isBlank()){
            throw new IllegalArgumentException("Input is Blank");
        }
        this.name = name;
    }

    public boolean checkPush(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
    public void move() {
        if (checkPush()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getPositionInString() {
        return "-".repeat(position);
    }
}

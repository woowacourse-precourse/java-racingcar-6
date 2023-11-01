package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    public String name;
    public Integer location;

    public Car(String carName) {
        name = carName;
        location = 0;
    }

    public void tryMove() {

        move(getMovable());
    }

    public void move(boolean movable) {

        if (movable) {
            this.location += 1;
        }
    }

    private boolean getMovable() {

        return pickNumberInRange(0, 9) >= 4;
    }

    public void printProgress() {

        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");

        for (int i = 0; i < location; i++) {
            sb.append("-");
        }

        System.out.println(sb);
    }
}

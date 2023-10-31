package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int moveDistance = 0;

    public boolean isAvailableMove() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return true;
        }
        return false;
    }

    public void printLocation() {
        System.out.print(name + " : ");
        for (int i = 0; i < moveDistance; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void moveForward() {
        moveDistance += 1;
    }

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}

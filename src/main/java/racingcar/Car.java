package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String inputName) {
        this.name = inputName;
        this.distance = 0;
    }

    public void printCarState() {
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void onceRoundStart() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            this.distance++;
        }
    }

    public int finalDistance() {
        return distance;
    }
}

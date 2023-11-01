package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int carDistance;
    private final int MINRANDOM = 0;
    private final int MAXRANDOM = 9;
    private final int NODISTANCE = 0;

    public Car(String carName) {

        this.carName = carName;
        this.carDistance = 0;
    }

    public String getCarName() {

        return carName;
    }

    public int getCarDistance() {

        return carDistance;
    }

    public void go() {

        int num = Randoms.pickNumberInRange(MINRANDOM, MAXRANDOM);

        if (num >= 4) {

            carDistance++;
        }

        printResult();
    }

    private void printResult() {

        System.out.print(carName + " : ");

        if (carDistance != NODISTANCE) {

            for (int i = 0; i < carDistance; i++) {

                System.out.print("-");
            }
        }

        System.out.println();
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int carDistance;
    private final int MINRANDOM = 0;
    private final int MAXRANDOM = 9;

    public Car(String carName) {

        this.carName = carName;
        this.carDistance = 0;
    }
    public void go() {

        randomGo();
    }

    private void randomGo() {

        int num = Randoms.pickNumberInRange(MINRANDOM, MAXRANDOM);

        if(num >= 4) {

            this.carDistance++;
        }

        printResult();
    }

    private void printResult() {

        System.out.print(this.carName + " : ");

        if(carDistance != 0) {

            for(int i = 0; i < carDistance; i++) {

                System.out.print("-");
            }
        }
    }
}

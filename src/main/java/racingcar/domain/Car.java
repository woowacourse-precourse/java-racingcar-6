package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String carName;
    public String status = "";

    public void drive() {
        int randomNumber = createRandomNumber();
        judgeRandomNumber(randomNumber);
        printCarStatus();
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void judgeRandomNumber(int randomNumber) {
        if (randomNumber >= 4) {
            status += '-';
        }
    }

    public void printCarStatus() {
        System.out.println(carName + " : " + status);
    }

}

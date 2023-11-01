package racingcar.domain;

import racingcar.utils.CarUtil;

public class Car {


    private int position = 0;
    private String name;

    private final CarUtil carUtil = new CarUtil();

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void attemptGo() {
        int number = carUtil.generateRandomNumber();
        if (carUtil.judgeGo(number)) {
            this.position++;
        }
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }

}

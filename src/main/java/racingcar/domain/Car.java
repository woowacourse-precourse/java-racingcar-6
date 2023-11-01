package racingcar.domain;

import racingcar.utils.GameUtil;

public class Car {

    GameUtil gameUtil = new GameUtil();

    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void attemptGo() {
        int number = gameUtil.generateRandomNumber();
        if (gameUtil.judgeGo(number)) {
            this.position++;
        }
    }

    public void printName() {

    }

}

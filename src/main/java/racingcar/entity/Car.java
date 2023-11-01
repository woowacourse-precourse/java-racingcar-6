package racingcar.entity;

import racingcar.IO.IOService;

public class Car {
    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    private String name;

    private Integer score;

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public void plusScore() {
        score += 1;
    }

    public void printStatus() {
        IOService.printNotice(name, makeProgressBar());
    }

    private String makeProgressBar() {
        return "-".repeat(score);
    }
}

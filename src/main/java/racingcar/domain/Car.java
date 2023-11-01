package racingcar.domain;

import racingcar.dto.CarStatusDto;


public class Car {
    private final static Integer START_SCORE = 0;

    private final String name;
    private Integer progressScore;

    private Car(String name) {
        this.name = name;
        this.progressScore = START_SCORE;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void tryProgress() {
        Progress progress = Progress.create();
        progressScore += progress.getScore();
    }

    public CarStatusDto sendStatus() {
        return CarStatusDto.create(name, progressScore);
    }
}
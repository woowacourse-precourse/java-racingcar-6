package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private int numberOfRepetition;

    public RacingGame(ArrayList<Car> cars, int numberOfRepetition) {
        this.cars = cars;
        this.numberOfRepetition = numberOfRepetition;
    }
}

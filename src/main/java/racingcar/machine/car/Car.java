package racingcar.machine.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.machine.util.random.RandomsAdapter;
import racingcar.machine.util.random.RandomsProvider;

public class Car implements CarInterface {
    private final String name;
    private final RandomsProvider randomsAdapter;
    private int distance;


    public Car(String name, RandomsProvider randomsProvider) {
        this.name = name;
        this.randomsAdapter = randomsProvider;
    }

    @Override
    public void tryForwardMove() {
        int number = randomsAdapter.pickNumberInRange(0, 9);
        if (number >= 4) distance++;
    }

    @Override
    public String carMoveLength() {
        return this.name + " : " + "-".repeat(Math.max(0, this.distance));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return name;
    }
}

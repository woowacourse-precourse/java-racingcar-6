package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private final List<Car> cars;
    private final int times;

    public Player(List<Car> cars, int times){
        this.cars = cars;
        this.times = times;
    }

}

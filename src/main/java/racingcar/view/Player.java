package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<String> carNames = new ArrayList<>();

    public Player() {
    }

    public void promptCarNames() {
        carNames = Arrays.asList(Console.readLine().split(","));
    }

    public List<String> getCarNames() {
        return carNames;
    }
}



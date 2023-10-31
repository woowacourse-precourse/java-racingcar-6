package racingcar.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.DataTypeChanger;
import racingcar.view.SystemOutput;
import racingcar.view.UserInput;

public class RaceController {
    private static final int FIRST_RANK = 0;
    private final LinkedHashMap<Integer, List<String>> ranks = new LinkedHashMap<>();

    private Cars cars;

    public void start() {
        List<String> names = inputCarNames();
        List<Car> carNames = DataTypeChanger.stringToCar(names);
        cars = new Cars(carNames);

        tryMove(cars);

        calculateRanking(names, carNames);
        SystemOutput.printWinner(ranks.get(FIRST_RANK));
    }

    private List<String> inputCarNames() {
        SystemOutput.printInputCarNames();
        List<String> names = UserInput.carName();
        return names;
    }

    private void tryMove(Cars cars) {
        int trial = inputTrialNumber();
        SystemOutput.printThisIsResult();

        for (int i = 0; i < trial; i++) {
            cars.move();
            SystemOutput.printResult(cars.indicate());
        }
    }

    private int inputTrialNumber() {
        SystemOutput.printInputTrialCount();
        int trial = UserInput.trialCount();
        return trial;
    }

    private void calculateRanking(List<String> names, List<Car> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            int compare = cars.compare(carNames.get(i));
            List<String> rank = ranks.getOrDefault(compare, new ArrayList<>());
            rank.add(names.get(i));
            ranks.put(compare, rank);
        }
    }
}

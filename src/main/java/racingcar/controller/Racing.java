package racingcar.controller;

import static racingcar.constant.AllConstants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final InputView inputView;
    private final OutputView outputView;
    private final Car car;
    private final Rounds rounds;

    public Racing() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.car = new Car();
        this.rounds = new Rounds();
    }

    public void play() {
        startRace();
        Map<String, Integer> carNameList = car.createCarNameList(inputView.inputCarName());
        int counts = rounds.getRounds(inputView.inputRounds());
        outputView.printTotalResult();
        for (int i = 0; i < counts; i++) {
            playRound(carNameList);
        }
        outputView.printWinnerList(getWinnerList(carNameList));
        finishRace();
    }

    private void startRace() {
        outputView.printRaceStart();
    }
    private void playRound(Map<String, Integer> carNameList) {
        for (String carName : carNameList.keySet()) {
            int moves = carNameList.get(carName);
            carNameList.put(carName, progressOrNot(moves));
            outputView.printProgressOfCar(carName, carNameList.get(carName));
        }
        System.out.println();
    }
    private Integer progressOrNot(int currentMoves) {
        int randomNum = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (randomNum >= RANDOM_FOUR) {
            currentMoves += MOVE_FORWARD;
        }
        return currentMoves;
    }

    private List<String> getWinnerList(Map<String, Integer> carNameList) {
        List<String> result = new ArrayList<>();
        Integer maxValue = Collections.max(carNameList.values());
        for (String carName : carNameList.keySet()) {
            if (maxValue.equals(carNameList.get(carName))) {
                result.add(carName);
            }
        }
        return result;
    }

    private void finishRace() {
        outputView.printRaceFinish();
        Console.close();
    }
}
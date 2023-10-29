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
        startRacing();
        Map<String, Integer> carNameList = car.createCarNameList(inputView.inputCarName());
        int counts = rounds.getRounds(inputView.inputRounds());
        outputView.printTotalResult();
        playAllRounds(carNameList, counts);
        outputView.printWinnerList(getWinnerList(carNameList));
        finishRacing();
    }

    public void playAllRounds(Map<String, Integer> carNameList, int counts) {
        for (int i = 0; i < counts; i++) {
            Map<String, Integer> oneRoundResult = playOneRound(carNameList);
            outputView.printProgressOfAllCars(oneRoundResult);
        }
    }

    public Map<String, Integer> playOneRound(Map<String, Integer> carNameList) {
        for (String carName : carNameList.keySet()) {
            int moves = carNameList.get(carName);
            int randomNum = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            carNameList.put(carName, progressOrNot(moves, randomNum));
        }
        return carNameList;
    }

    public Integer progressOrNot(int currentMoves, int randomNum) {
        if (randomNum >= RANDOM_FOUR) {
            currentMoves += MOVE_FORWARD;
        }
        return currentMoves;
    }

    public List<String> getWinnerList(Map<String, Integer> carNameList) {
        List<String> result = new ArrayList<>();
        Integer maxValue = Collections.max(carNameList.values());
        for (String carName : carNameList.keySet()) {
            if (maxValue.equals(carNameList.get(carName))) {
                result.add(carName);
            }
        }
        return result;
    }

    private void startRacing() {
        outputView.printRaceStart();
    }

    private void finishRacing() {
        outputView.printRaceFinish();
        Console.close();
    }
}
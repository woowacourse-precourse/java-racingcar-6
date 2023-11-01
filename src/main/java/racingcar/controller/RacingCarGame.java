package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.model.UserCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private OutputView outputView = new OutputView();
    private int roundNumber;
    private UserCar userCar;
    private Map<String, Integer> car;
    private InputView inputView = new InputView();
    private List<String> winner;
    private UserCarService userCarService = new UserCarService();

    private void generateCarNumber() {
        int number;
        for (String key : car.keySet()) {
            number = Randoms.pickNumberInRange(0, 9);
            decideForward(number, key);
        }
    }

    private void decideForward(int number, String key) {
        if (number >= 4) {
            car.put(key, car.get(key) + 1);
        }
    }

    private void gameResult() {
        winner = new ArrayList<>();
        int maxDistance = Collections.max(car.values());

        for (Entry<String, Integer> m : car.entrySet()) {
            calculate(m, maxDistance);
        }
    }

    private void calculate(Entry<String, Integer> m, int maxDistance) {
        if (m.getValue() == maxDistance) {
            winner.add(m.getKey());
        }
    }

    public void game() {
        userCar = new UserCar(inputView.inputCarNameView());
        this.car = userCar.getCar();
        userCarService.checkCorrectName(car);
        this.roundNumber = inputView.inputRoundNumber();

        System.out.println("실행결과");
        for (int i = 0; i < roundNumber; i++) {
            generateCarNumber();
            outputView.currentLocation(car);
            System.out.println("");
        }

        gameResult();
        outputView.printWinner(winner);
    }
}

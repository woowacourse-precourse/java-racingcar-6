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
    private OutputView outputView;
    private int roundNumber;
    private UserCar userCar;
    private Map<String, Integer> car;
    private InputView inputView;
    private List<String> winner;
    private UserCarService userCarService;
    public RacingCarGame(){
        winner = new ArrayList<>();
        userCarService = new UserCarService();
        inputView = new InputView();
        outputView = new OutputView();
    }
    public List<String> getWinner(){
        return this.winner;
    }
    public void setCar(Map<String, Integer> car) {
        this.car = car;
    }

    public void generateCarNumber() {
        int number;
        for (String key : car.keySet()) {
            number = Randoms.pickNumberInRange(0, 9);
            decideForward(number, key);
        }
    }

    public void decideForward(int number, String key) {
        if (number >= 4) {
            car.put(key, car.get(key) + 1);
        }
    }

    public void gameResult() {
        int maxDistance = Collections.max(car.values());

        for (Entry<String, Integer> m : car.entrySet()) {
            calculate(m, maxDistance);
        }
    }

    public void calculate(Entry<String, Integer> m, int maxDistance) {
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

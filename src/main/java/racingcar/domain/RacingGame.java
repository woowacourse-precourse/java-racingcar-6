package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<Car>();
    private int maxRound = 0;
    private UI ui = null;

    public RacingGame(UI ui, Validator validator) {
        this.ui = ui;
    }

    public void startGame() {
        cars = ui.inputCarNames();
        int inputRound = ui.inputRounds();
        setMaxRound(inputRound);
    }

    public void runGame() {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < maxRound; i++) {
            round(cars);
            ui.showResult(cars);
        }

        ui.showFinalResult(cars);
    }

    public void round(List<Car> cars) {
        for (Car car : cars) {
            int nowPosition = car.getPosition();
            if (randomGoOrStop()) car.setPosition(nowPosition + 1);
        }
    }

    public boolean randomGoOrStop() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum >= 4;
    }

    public void setMaxRound(int maxRound) {
        this.maxRound = maxRound;
    }
}

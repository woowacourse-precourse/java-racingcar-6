package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    private Integer tryNumber;
    List<RacingCar> racingCarList;

    public RacingCarGame() {
        this.tryNumber = 0;
        this.racingCarList = new ArrayList<>();
    }

    public void play() {
        requestCarNames();
        requestTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            tryOnce();
        }
        printWinners();
    }

    private void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        Arrays.stream(carNames).forEach(carName -> {
            racingCarList.add(new RacingCar(carName));
        });
    }

    private void requestTryNumber() {

    }

    private void tryOnce() {

    }

    private void printWinners() {

    }
}

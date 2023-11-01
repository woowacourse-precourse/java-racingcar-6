package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame extends Game{
    private final List<RacingCar> car = new ArrayList<>();
    private int tryCount;

    @Override
    public void initGame() {
        String[] carNames = InputHandler.getCarNames("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
        tryCount = InputHandler.getRaceCount();
    }

    @Override
    protected void playGame() {
        for (int i = 0; i < raceCount; i++) {
            playRound();
            System.out.println(); // 줄바꿈으로 각 라운드 구분
        }
        String winners = determineWinners();
        OutputHandler.printWinners(winners);
    }

    private void playRound() {
        for (RacingCar car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            OutputHandler.printCarStatus(car.getName(), car.getPosition());
        }
    }

    
}

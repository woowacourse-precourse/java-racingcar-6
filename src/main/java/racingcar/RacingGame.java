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
    public void playGame(){

    }

    public void printCarPosition(RacingCar car) {
        OutputHandler(RacingCar.getName() + " : ");
        for(int i = 0; i < car.get)
    }
}

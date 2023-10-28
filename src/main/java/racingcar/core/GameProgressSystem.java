package racingcar.core;

import racingcar.domain.Car;

import java.util.List;

public class GameProgressSystem {
    private final WinnerCheckSystem winnerCheckSystem;
    private final Output output;
    private boolean endFlag = false;

    public GameProgressSystem(final WinnerCheckSystem winnerCheckSystem,final Output output) {
        this.winnerCheckSystem = winnerCheckSystem;
        this.output = output;
    }

    public void progress(List<Car> cars){
        for (Car car : cars) {
            car.tryMove();
        }

        // 우승체크시스템 미구현
        List<Car> winner = winnerCheckSystem.check(cars);

        if (winner.size() >= 1) {
            endFlag = true;
        }
        output.printResult(cars);
    }

    public boolean endCheck(){
        return endFlag;
    }
}

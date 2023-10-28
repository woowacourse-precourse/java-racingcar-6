package racingcar.core;

import racingcar.domain.Car;

import java.util.List;

public class GameProgressSystem {
    private final Output output;
    private boolean endFlag = false;

    public GameProgressSystem(final Output output) {
        this.output = output;
        // 우승체크시스템 넣어줘야함
    }

    public void progress(List<Car> cars){
        for (Car car : cars) {
            car.tryMove();
        }

        // 우승체크시스템 미구현

        output.printResult(cars);
    }

    public boolean endCheck(){
        return endFlag;
    }
}

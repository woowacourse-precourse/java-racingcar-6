package racingcar.core;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;

import java.util.List;

public class GameManager {
    private final Input input;
    private final Output output;
    private final CarFactory factory;
    private final GameProgressSystem progressSystem;

    public GameManager(final Input input, final Output output, final CarFactory factory) {
        this.input = input;
        this.output = output;
        this.factory = factory;
        this.progressSystem = new GameProgressSystem(output);
        // 우승체크 시스템 주입
    }

    public void play(){
        String stringNames = input.readNames();
        int tryNum = input.readTryNum();

        List<Car> carList = factory.factory(stringNames);
        // 우승 체크에 tryNum

        do {
            progressSystem.progress(carList);
        } while (progressSystem.endCheck());

        /**
         * 우승체크 시스템으로부터 우승 리스트 받음
         * if len > 1 -> output.printSingleWinner(우승 리스트);
         * else -> output.printMultiWinner(우승 리스트)
         */

    }

}

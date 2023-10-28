package racingcar.core;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;

import java.util.List;

public class GameManager {
    private final Input input;
    private final Output output;
    private final CarFactory factory;
    private final GameProgressSystem progressSystem;
    private final WinnerCheckSystem winnerCheckSystem;
    private final GameAwards gameAwards;

    public GameManager(final Input input, final Output output, final CarFactory factory, final GameProgressSystem progressSystem, final WinnerCheckSystem winnerCheckSystem, final GameAwards gameAwards) {
        this.input = input;
        this.output = output;
        this.factory = factory;
        this.progressSystem = progressSystem;
        this.winnerCheckSystem = winnerCheckSystem;
        this.gameAwards = gameAwards;
    }

    public void play(){
        String stringNames = input.readNames();
        int tryNum = input.readTryNum();

        List<Car> carList = factory.factory(stringNames);

        for (int i = 0; i < tryNum; i++) {
            List<Car> progressedCar = progressSystem.progress(carList);
            output.printResult(progressedCar);
        }

        List<String> awardsList = gameAwards.awards(carList);
        output.printWinner(awardsList);

    }

}

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

    public GameManager(final Input input, final Output output, final CarFactory factory) {
        this.input = input;
        this.output = output;
        this.factory = factory;
        this.winnerCheckSystem = new WinnerCheckSystem();
        this.progressSystem = new GameProgressSystem(winnerCheckSystem,output);
        // 우승체크 시스템 주입
    }

    public void play(){
        String stringNames = input.readNames();
        int tryNum = input.readTryNum();

        List<Car> carList = factory.factory(stringNames);
        winnerCheckSystem.setMaxLine(tryNum);

        for (int i = 0; i < tryNum; i++) {
            progressSystem.progress(carList);
            if (progressSystem.endCheck()) {
                break;
            }
        }
        List<Car> winners = winnerCheckSystem.getWinners();
        List<String> winnerString = factory.getNames(winners);
        output.printMultiWinner(winnerString);

    }

}

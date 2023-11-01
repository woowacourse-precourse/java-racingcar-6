package racingcar.service;

import racingcar.model.RacingCars;
import racingcar.utils.Utils;
import racingcar.view.InputView;
import racingcar.view.OuterView;

import java.util.stream.IntStream;

public class RaceService {

    RacingCars racingCars = new RacingCars();
    int maxGames;

    public void init() {
        initCars();
        initGames();
    }

    private void initCars() {
        Utils.split(InputView.inputRacingCars()).forEach(carName -> {
            racingCars.setCar(carName);
        });
    }

    private void initGames() {
        this.maxGames = Integer.parseInt(InputView.inputGames());
    }

    public void play() {
        // 게임 진행
        runGames();

        // 최종 우승자 표시
        closeGame();
    }

    private void runGames() {
        IntStream.range(0, maxGames).forEach(i -> {
            racingCars.runCars();
            OuterView.printStatus(i, racingCars.extractStatusString());
        });
    }

    private void closeGame() {

    }
}

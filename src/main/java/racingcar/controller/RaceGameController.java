package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGameController {
    private InputView inputView;
    private OutputView outputView;

    public RaceGameController() {

    }

    public void startGame() {
        inputView.printStartMessage();
        //차후 보완
        String names = Console.readLine();
        RacingCars racingCars = new RacingCars();
        racingCars.carCreator(inputspliter(names));
        inputView.printLoopSetMessage();
        int loop = Integer.parseInt(Console.readLine());
        for(int i = 0 ; i < loop; i++){
            playingGame();
        }
    }

    public void playingGame() {

    }

    public List<String> inputspliter(String name) {
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }
}

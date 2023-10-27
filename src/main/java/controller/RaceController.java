package controller;

import domain.RaceService;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final RaceService raceService;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController() {
        raceService = new RaceService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        String carNames = inputView.enterCarNames();
        int tryNumber = inputView.enterTryNumber();
        List<String> carNamesList = raceService.carNamesToList(carNames);
        int[] result = new int[carNamesList.size()];
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            raceService.getResult(carNamesList, result);
            outputView.printResult(carNamesList, result);
        }
    }


}

package controller;

import domain.ConstantUtil;
import domain.RaceService;
import domain.ValidateInput;
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
        ValidateInput.nameLengthException(carNames);
        String tryNumber = inputView.enterTryNumber();
        ValidateInput.numberFormatException(tryNumber);
        int validatedTryNumber = Integer.parseInt(tryNumber);
        List<String> carNamesList = raceService.carNamesToList(carNames);
        int[] result = new int[carNamesList.size()];
        System.out.println(ConstantUtil.SHOW_RESULT_MESSAGE);
        for (int i = 0; i < validatedTryNumber; i++) {
            raceService.getResult(carNamesList, result);
            outputView.printResult(carNamesList, result);
        }
        int maxScore = raceService.getMaxScore(carNamesList, result);
        System.out.print(ConstantUtil.SHOW_WINNER_MESSAGE);
        List<String> winnerList = raceService.getWinnerList(carNamesList, result, maxScore);
        System.out.print(String.join(ConstantUtil.WINNER_JOIN_DELIMINATOR, winnerList));
    }


}

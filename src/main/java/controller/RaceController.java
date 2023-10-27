package controller;

import domain.RaceService;
import view.InputView;

public class RaceController {
    private final RaceService raceService;
    private final InputView inputView;

    RaceController(){
        raceService = new RaceService();
        inputView = new InputView();
    }

    public void play(){
        int tryNumber = inputView.enterTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            raceService.moveCarAndPrintResult();
        }
    }
}

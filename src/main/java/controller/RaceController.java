package controller;

import model.AttemptExecutor;
import model.AttemptResultPrinter;
import model.RaceDto;
import model.RaceInitializer;
import model.RaceWinnerPrinter;
import view.OutputView;

public class RaceController {

    private final RaceInitializer raceInitializer = new RaceInitializer();
    private final RaceDto raceDto;
    private final AttemptExecutor attemptExecutor;
    private final AttemptResultPrinter attemptResultPrinter;
    private final RaceWinnerPrinter raceWinnerPrinter;
    private final OutputView outputView = new OutputView();

    public RaceController() {
        this.raceDto = raceInitializer.initRace();
        this.attemptExecutor = new AttemptExecutor(raceDto);
        this.attemptResultPrinter = new AttemptResultPrinter(raceDto);
        this.raceWinnerPrinter = new RaceWinnerPrinter(raceDto);
    }

    public void run() {
        int attemptTimes = raceDto.getAttemptTimes();
        outputView.noticeRaceStart();
        for (int i = 0; i < attemptTimes; i++) {
            attemptExecutor.execute();
            attemptResultPrinter.print();
        }
        raceWinnerPrinter.print();
    }
}
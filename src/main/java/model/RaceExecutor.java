package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import view.OutputView;

public class RaceExecutor {

    private final AdvanceDecider advanceDecider = new AdvanceDecider();
    private final OutputView outputView = new OutputView();
    private final RaceDto raceDto;
    private final List<String> carNames;

    RaceExecutor(RaceDto raceDto) {
        this.raceDto = raceDto;
        this.carNames = raceDto.getCarNameToAdvanceMap().keySet().stream().toList();
    }

    public void execute() {
        for (int i = 0; i < raceDto.getAttemptTimes(); i++) {
            singleAttempt();
            printAttemptResult();
        }
    }

    private void singleAttempt() {
        for (String carName : carNames) {
            moveCarAtIfPossible(carName);
        }
    }

    private void moveCarAtIfPossible(String name) {
        if (advanceDecider.isPossibleToAdvance()) {
            moveCarByName(name);
        }
    }

    private void moveCarByName(String name) {
        String originalValue = getMovementString(name);
        raceDto.getCarNameToAdvanceMap().put(name, originalValue + "-");
    }

    private void printAttemptResult() {
        for (String carName : carNames) {
            outputView.printAttemptResult(carName, getMovementString(carName));
        }
    }

    private String getMovementString(String name) {
        return raceDto.getCarNameToAdvanceMap().get(name);
    }
}

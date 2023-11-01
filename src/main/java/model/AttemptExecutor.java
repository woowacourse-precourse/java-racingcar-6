package model;

import java.util.List;
import view.OutputView;

public class AttemptExecutor {

    private final AdvanceDecider advanceDecider = new AdvanceDecider();
    private final OutputView outputView = new OutputView();
    private final RaceDto raceDto;
    private final List<String> carNames;

    AttemptExecutor(RaceDto raceDto) {
        this.raceDto = raceDto;
        this.carNames = raceDto.getCarNameList();
    }

    public void execute() {
        for (int i = 0; i < raceDto.getAttemptTimes(); i++) {
            singleAttempt();
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
        String originalValue = raceDto.getCarNameToAdvanceMap().get(name);
        raceDto.getCarNameToAdvanceMap().put(name, originalValue + "-");
    }
}

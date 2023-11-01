package model;

import java.util.List;

public class AttemptExecutor {

    private final AdvanceDecider advanceDecider = new AdvanceDecider();
    private final RaceDto raceDto;
    private final List<String> carNames;

    public AttemptExecutor(RaceDto raceDto) {
        this.raceDto = raceDto;
        this.carNames = raceDto.getCarNameList();
    }

    public void execute() {
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

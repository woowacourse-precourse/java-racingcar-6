package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import view.OutputView;

public class RaceExecutor {

    private final MovementDecider movementDecider = new MovementDecider();
    private final OutputView outputView = new OutputView();
    private final RaceDto raceDto;
    private List<String> names;

    RaceExecutor(RaceDto raceDto) {
        this.raceDto = raceDto;
        this.names = raceDto.getCars().keySet().stream().toList();
    }

    public void execute(){
        for (int i = 0; i < raceDto.getAttemptTimes(); i++) {
            singleAttempt();
            printAttemptResult();
        }
    }

    private void singleAttempt() {
        for (String name : names) {
            moveCarAtIfPossible(name);
        }
    }

    private void moveCarAtIfPossible(String name) {
        if (movementDecider.decide()) {
            moveCarByName(name);
        }
    }

    private void moveCarByName(String name) {
        String originalValue = getMovementString(name);
        raceDto.getCars().put(name, originalValue + "-");
    }

    private void printAttemptResult(){
        for (String name : names) {
            outputView.printAttemptResult(name, getMovementString(name));
        }
    }

    private String getMovementString(String name){
        return raceDto.getCars().get(name);
    }
}

package model;

import java.util.List;
import view.OutputView;

public class AttemptResultPrinter {
    private final RaceDto raceDto;
    private final OutputView outputView = new OutputView();

    AttemptResultPrinter(RaceDto raceDto){
        this.raceDto = raceDto;
    }

    private void printAttemptResult(RaceDto raceDto) {
        List<String> carNames = raceDto.getCarNameList();
        for (String carName : carNames) {
            outputView.printAttemptResult(carName, getMovementString(carName));
        }
    }

    private String getMovementString(String name) {
        return raceDto.getCarNameToAdvanceMap().get(name);
    }
}

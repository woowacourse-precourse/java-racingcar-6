package model;

import java.util.List;
import view.OutputView;

public class AttemptResultPrinter {

    private final RaceDto raceDto;
    private final OutputView outputView = new OutputView();
    private final List<String> carNames;

    public AttemptResultPrinter(RaceDto raceDto) {
        this.raceDto = raceDto;
        this.carNames = raceDto.getCarNameList();
    }

    public void print() {
        for (String carName : carNames) {
            outputView.printAttemptResult(carName, getMovementString(carName));
        }
        outputView.printNewLine();
    }

    private String getMovementString(String name) {
        return raceDto.getCarNameToAdvanceMap().get(name);
    }
}

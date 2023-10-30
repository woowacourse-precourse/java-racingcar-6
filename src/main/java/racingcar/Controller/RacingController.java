package racingcar.Controller;

import racingcar.ValidateInput;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingController {
    private final static String DELIMITER = ",";

    private RacingCars racingCars = new RacingCars();
    private List<String> racingCarNames;
    private List<Integer> racingCarLocations;

    public void start() {

        String[] carNames = getUserInputNames();
        racingCars.addCars(carNames);

        int trialNumber = getUserInputTrialNumber();

        processRacing(trialNumber);

        OutputView.printWinner(racingCars.getWinners());

    }

    private String[] getUserInputNames() {
        String input = InputView.inputCarNames();
        ValidateInput.isNotNullOrEmpty(input);

        String[] carNames = input.split(DELIMITER);
        ValidateInput.isRightCarNames(carNames);

        return carNames;
    }

    private int getUserInputTrialNumber() {
        String input = InputView.inputTrialNumber();
        ValidateInput.isNotNullOrEmpty(input);
        ValidateInput.isNumeric(input);

        int trialNumber = Integer.parseInt(input);
        return trialNumber;
    }

    private void processRacing(int trialNumber) {

        OutputView.processPrintStartMessage();

        racingCarNames = racingCars.getCarNames();
        for (int cnt = 0; cnt < trialNumber; cnt++) {
            oneTrial(racingCarNames);
        }
    }

    private void oneTrial(List<String> names) {
        racingCars.move();

        racingCarLocations = racingCars.getCarLocations();

        for (int idx = 0; idx < names.size(); idx++) {
            OutputView.printCarName(names.get(idx));
            OutputView.printCarLocation(racingCarLocations.get(idx));
        }
        OutputView.printEmptyLine();
    }

}

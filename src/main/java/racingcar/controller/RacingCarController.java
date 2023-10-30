package racingcar.controller;

import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;
import racingcar.service.TrialCounter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarController {

    private final TrialCounter trialCounter;
    private final NumberGenerator numberGenerator;

    public RacingCarController() {
        this.trialCounter = new TrialCounter();
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void run() {
        initiation();
        while (!trialCounter.isFinish()) {
            move();
        }
        getResult();
    }

    private void initiation() {
        setCars();
        setTrialCount();
    }

    private void setCars() {
        try {
            String carsInput = InputView.inputCars();
            List<String> carsName = splitCarsInput(carsInput);
            CarRepository.makeCars(carsName);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            setCars();
        }
    }

    private void setTrialCount() {
        try {
            int trialInput = InputView.inputTrialCount();
            trialCounter.initTrialCount(trialInput);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            setTrialCount();
        }
    }

    private void move() {
        Map<String, Integer> moveResults =  CarRepository.move(numberGenerator);
        trialCounter.takeTrial();
        OutputView.printMoveResult(moveResults);
    }

    private void getResult() {
        List<String> winners = CarRepository.getWinners();
        OutputView.printWinners(winners);
    }

    private List<String> splitCarsInput(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
}

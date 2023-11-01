package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Racer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final InputView inputView;
    private final OutputView outputView;

    public Racing() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String racerNames = inputView.inputRacerNames();

        int tryCount = inputView.inputTryCount();

        List<Racer> racers = createRacers(racerNames);

        raceAndPrintResults(racers, tryCount);
    }

    private List<Racer> createRacers(String racerNames) {
        String[] names = racerNames.split(",");
        List<Racer> racers = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            racers.add(new Racer(name));
        }
        return racers;
    }

    private void raceAndPrintResults(List<Racer> racers, int tryCount) {

        outputView.printResult();

        for (int i = 0; i < tryCount; i++) {
            for (Racer racer : racers) {
                racer.move();
            }
            outputView.printPositions(racers);
        }

        List<String> winners = determineWinners(racers);
        outputView.printWinners(winners);
    }

    private List<String> determineWinners(List<Racer> racers) {
        int maxPosition = racers.stream().mapToInt(Racer::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Racer racer : racers) {
            if (racer.getPosition() == maxPosition) {
                winners.add(racer.getName());
            }
        }
        return winners;
    }
}

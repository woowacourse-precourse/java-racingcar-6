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
        // 경주할 자동차 이름 입력 받기
        String racerNames = inputView.inputRacerNames();

        // 시도 횟수 입력 받기
        int tryCount = inputView.inputTryCount();

        // 자동차 객체 생성
        List<Racer> racers = createRacers(racerNames);

        // 경주 진행 및 결과 출력
        raceAndPrintResults(racers, tryCount);
    }

    private List<Racer> createRacers(String racerNames) {
        String[] names = racerNames.split(",");
        List<Racer> racers = new ArrayList<>();
        for (String name : names) {
            racers.add(new Racer(name));
        }
        return racers;
    }

    private void raceAndPrintResults(List<Racer> racers, int tryCount) {
        outputView.printInitialPositions(racers);

        for (int i = 0; i < tryCount; i++) {
            for (Racer racer : racers) {
                racer.move(); // 각 자동차가 이동하는 로직을 구현
            }
            outputView.printPositions(racers);
        }

        List<String> winners = determineWinners(racers);
        outputView.printWinners(winners);
    }

    private List<String> determineWinners(List<Racer> racers) {
        // 가장 멀리 이동한 자동차(들)을 찾아 우승자로 결정
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

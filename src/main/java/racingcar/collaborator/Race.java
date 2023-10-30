package racingcar.collaborator;

import java.util.ArrayList;
import java.util.List;
import racingcar.collaborator.generic.LapProgress;
import racingcar.collaborator.generic.RaceTotalProgress;
import racingcar.collaborator.generic.RacerProgress;
import racingcar.io.Input;
import racingcar.io.Output;

public class Race {

    private final List<LapProgress> lapProgresses;
    private List<Racer> racers;
    private Integer numberOfRound;

    public Race() {
        this.lapProgresses = new ArrayList<>();
    }

    public void registerRacer(List<Racer> racers) {
        this.racers = racers;
    }

    public void decideRoundNumber() {
        Output.consoleLine("시도할 회수는 몇회인가요?");
        numberOfRound = Input.consoleNumber();
        Output.consoleLine(); // 입력 후 공백 한 줄이 들어가게 되어있음
    }

    public void run() {
        for (int i = 0; i < numberOfRound; i++) {
            driveEachRacer();
            saveProgressEachRacer();
        }
    }

    private void driveEachRacer() {
        for (Racer racer : racers) {
            racer.drive();
        }
    }

    private void saveProgressEachRacer() {
        List<RacerProgress> list = new ArrayList<>();
        for (Racer racer : racers) {
            RacerProgress progress = racer.getProgress();
            list.add(progress);
        }
        lapProgresses.add(new LapProgress(list));
    }

    public RaceTotalProgress getTotalProgress() {
        return new RaceTotalProgress(lapProgresses);
    }

}

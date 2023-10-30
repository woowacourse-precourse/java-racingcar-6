package racingcar.collaborator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import racingcar.collaborator.generic.RaceProgress;
import racingcar.collaborator.generic.RacerProgress;
import racingcar.collaborator.generic.RecordingRace;
import racingcar.collaborator.generic.Winners;
import racingcar.io.Input;
import racingcar.io.Output;

public class Race {

    private List<Racer> racers;
    private Integer numberOfRound;
    private List<RaceProgress> raceProgress;

    public Race() {
        this.raceProgress = new ArrayList<>();
    }

    public void registerRacer() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racers = Input.consoleStrings(",").stream()
                .map(Racer::new)
                .toList();
    }

    public void decideRound() {
        Output.consoleLine("시도할 회수는 몇회인가요?");
        numberOfRound = Input.consoleNumber();
        Output.consoleLine(""); // 입력 후 공백 한 줄이 들어가게 되어있음
    }

    public void run() {
        for (int i = 0; i < numberOfRound; i++) {
            for (Racer racer : racers) {
                racer.drive();
            }

            List<RacerProgress> list = new ArrayList<>();
            for (Racer racer : racers) {
                RacerProgress progress = racer.getProgress();
                list.add(progress);
            }
            raceProgress.add(new RaceProgress(list));
        }
    }

    public RecordingRace getRecorded() {
        return new RecordingRace(raceProgress);
    }

    public Winners decideWinner() {
        List<String> winners = getLastMeter().stream()
                .filter(racerProgress ->
                        Objects.equals(racerProgress.mileage(), getBiggestMileage()))
                .map(RacerProgress::name)
                .toList();
        return new Winners(winners);
    }

    private Integer getBiggestMileage() {
        return getLastMeter().stream()
                .sorted(Comparator.comparingInt(RacerProgress::mileage).reversed())
                .map(RacerProgress::mileage)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("값이 없는 상태를 허용하지 않음."));
    }

    private List<RacerProgress> getLastMeter() {
        return raceProgress.get(numberOfRound - 1).racerProgress();
    }
}

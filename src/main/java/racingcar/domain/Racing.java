package racingcar.domain;

import java.util.List;
import racingcar.util.InputUtil;

public class Racing {

    private int racingTrial;
    private Participants participants;
    private final InputUtil inputUtil = new InputUtil();

    public void prepareRacing() {
        this.racingTrial = setRacingTrial();
    }

    private int setRacingTrial() {
        int trialInput = inputUtil.inputRacingTrial();
        if (trialInput == 0) {
            throw new IllegalArgumentException();
        }
        return trialInput;
    }

    public void race(Participants participants) {
        this.participants = participants;
        for (int i = 0; i < racingTrial; i++) {
            participants.race();
        }
    }

    public String judge() {
        List<Car> winner = judgeWinner();
        return "";
    }

    public List<Car> judgeWinner() {
        List<Car> participantsCars = participants.getCars();
        int maxMovedDistance = participantsCars.stream().mapToInt(Car::getMovedDistance).max().orElse(0);
        return participantsCars.stream()
                .filter(car -> car.getMovedDistance() == maxMovedDistance)
                .toList();
    }
}

package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.InputDelimiter;
import racingcar.util.InputUtil;

public class Racing {

    private int racingTrial;
    private Participants participants;
    private final InputUtil inputUtil = new InputUtil();

    public void race() {
        prepareRacing();
        startRace();
    }

    private void prepareRacing() {
        this.participants = new Participants(setParticipant());
        this.racingTrial = setRacingTrial();
    }

    private void startRace() {
        while (racingTrial > 0) {
            participants.race();
            racingTrial--;
        }
    }

    private List<Car> setParticipant() {
        String participantInput = inputUtil.inputCarName();
        if (participantInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return convertStringToList(participantInput);
    }

    private List<Car> convertStringToList(String participantInput) {
        List<String> rawParticipantInput = Arrays.stream(
                participantInput.split(InputDelimiter.PARTICIPANT_INPUT_DELIMITER.getValue())).toList();
        return rawParticipantInput.stream().map(carName -> new Car(carName, 0)).toList();
    }

    private int setRacingTrial() {
        int trialInput = inputUtil.inputRacingTrial();
        if (trialInput == 0) {
            throw new IllegalArgumentException();
        }
        return trialInput;
    }

}

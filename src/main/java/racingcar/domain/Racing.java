package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.InputDelimiter;
import racingcar.util.InputUtil;

public class Racing {

    private int racingTrial;
    private List<Participant> participants;
    private final InputUtil inputUtil = new InputUtil();

    public void prepareRacing() {
        this.racingTrial = setRacingTrial();
        this.participants = convertStringToList(setParticipant());
    }

    private String setParticipant() {
        String participantInput = inputUtil.inputCarName();
        if (participantInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return participantInput;
    }

    private List<Participant> convertStringToList(String participantInput) {
        List<String> rawParticipantInput = Arrays.stream(
                participantInput.split(InputDelimiter.PARTICIPANT_INPUT_DELIMITER.getValue())).toList();
        return rawParticipantInput.stream().map(carName -> new Participant(carName, 0)).toList();
    }

    private int setRacingTrial() {
        int trialInput = inputUtil.inputRacingTrial();
        if (trialInput == 0) {
            throw new IllegalArgumentException();
        }
        return trialInput;
    }

}

package racingcar.util;

import racingcar.UserInput;
import racingcar.domain.GameInfo;
import racingcar.domain.Participant;
import racingcar.exception.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class GameSetting {
    private final UserInput userInput;

    public GameSetting(UserInput userInput) {
        this.userInput = userInput;
    }

    public GameInfo createGameInfo() {
        List<String> nameList = Parser.splitName(userInput.readUserInputNames(), ",");
        Validator.validateName(nameList);

        String attemptNum = userInput.readUserInputAttemptNum();
        Validator.validateAttemptNum(attemptNum);

        List<Participant> participants = makeParticipants(nameList);
        return new GameInfo(participants, Integer.parseInt(attemptNum));
    }

    public List<Participant> makeParticipants(List<String> nameList) {
        return nameList
                .stream()
                .map(s -> new Participant(s, 0))
                .collect(Collectors.toList());
    }
}

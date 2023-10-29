package racingcar.util;

import racingcar.UserInput;
import racingcar.entity.GameInfo;
import racingcar.entity.Participant;
import racingcar.exception.InputException;

import java.util.List;
import java.util.stream.Collectors;

public class GameSetting {
    private final UserInput userInput;

    public GameSetting(UserInput userInput) {
        this.userInput = userInput;
    }

    public GameInfo createGameInfo() {
        List<String> nameList = Parser.splitName(userInput.getUserInputNames(), ",");
        InputException.validateName(nameList);

        String attemptNum = userInput.getUserInputAttemptNum();
        InputException.validateAttemptNum(attemptNum);

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

package racingcar.util;

import racingcar.UserInput;
import racingcar.entity.GameInfo;
import racingcar.entity.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class GameSetting {
    private final UserInput userInput;

    public GameSetting(UserInput userInput) {
        this.userInput = userInput;
    }

    public GameInfo createGameInfo() {
        return new GameInfo(makeParticipants(), userInput.getUserInputAttemptNum());
    }

    public List<Participant> makeParticipants() {
        return Parser.splitName(userInput.getUserInputNames(), ",")
                .stream()
                .map(s -> new Participant(s, 0))
                .collect(Collectors.toList());
    }
}

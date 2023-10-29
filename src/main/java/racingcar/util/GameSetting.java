package racingcar.util;

import racingcar.Game;
import racingcar.UserInput;
import racingcar.entity.GameInfo;
import racingcar.entity.Participant;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {
    private final UserInput userInput;

    public GameSetting(UserInput userInput) {
        this.userInput = userInput;
    }

    public GameInfo getGameInfo() {
        return new GameInfo(makeParticipants(), userInput.getUserInputAttemptNum());
    }

    public List<Participant> makeParticipants() {
        List<Participant> participants = new ArrayList<>();
        for(String name : Parser.splitName(userInput.getUserInputNames(), ",")) {
            participants.add(new Participant(name, 0));
        }
        return participants;
    }
}

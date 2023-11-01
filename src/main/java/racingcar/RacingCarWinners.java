package racingcar;

import java.util.List;

public record RacingCarWinners(List<Name> winners) {

    public boolean contains(Name name) {
        return winners().contains(name);
    }
}

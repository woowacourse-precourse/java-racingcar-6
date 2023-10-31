package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class PlayerNamesDto {
    private final List<String> playerNames;

    public PlayerNamesDto(final List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static PlayerNamesDto from(final List<String> playerNames) {
        return new PlayerNamesDto(playerNames);
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}

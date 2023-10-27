package racingcar;

import java.util.List;
import util.stringconverter.RacingCarConverter;

public class RacingCarFormatter {
    final RacingCarConverter converter;

    public RacingCarFormatter() {
        this.converter = new RacingCarConverter();
    }

    public String racingCarPlayerToString(RacingCarPlayer player) {
        return this.converter.toString(player);
    }

    public RacingCarPlayer racingCarPlayerFromString(String string) {
        return this.converter.fromString(string);
    }

    public List<String> racingCarPlayersToListString(List<RacingCarPlayer> players) {
        return players.stream().map(this::racingCarPlayerToString).collect(java.util.stream.Collectors.toList());
    }

    public String racingCarPlayersToString(List<RacingCarPlayer> players) {
        return String.join(", ", this.racingCarPlayersToListString(players));
    }
}

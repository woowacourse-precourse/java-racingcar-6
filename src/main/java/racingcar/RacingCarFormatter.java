package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import util.stringconverter.RacingCarConverter;

public class RacingCarFormatter {
    final RacingCarConverter converter;

    public RacingCarFormatter() {
        this.converter = new RacingCarConverter();
    }

    public String formatRacingCarPlayerToString(RacingCarPlayer player) {
        return this.converter.toString(player);
    }

    public RacingCarPlayer formatStringToRacingCarPlayer(String string) {
        return this.converter.fromString(string);
    }

    public List<String> formatListRacingCarPlayersToListString(List<RacingCarPlayer> players) {
        return players.stream().map(this::formatRacingCarPlayerToString).collect(Collectors.toList());
    }

    public String formatListRacingCarPlayersToString(List<RacingCarPlayer> players) {
        return String.join(", ", this.formatListRacingCarPlayersToListString(players));
    }

    public List<RacingCarPlayer> formatListStringToListRacingCarPlayer(List<String> players){
        return players.stream().map(this::formatStringToRacingCarPlayer).collect(Collectors.toList());
    }
}

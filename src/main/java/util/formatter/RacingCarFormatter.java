package util.formatter;

import static racingcar.Constants.COMMA_BLANK;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCarPlayerModel;
import util.stringconverter.RacingCarConverter;

public class RacingCarFormatter extends Formatter {
    final RacingCarConverter converter;

    public RacingCarFormatter() {
        this.converter = new RacingCarConverter();
    }

    public String formatPlayerToString(RacingCarPlayerModel player) {
        return this.converter.toString(player);
    }

    public RacingCarPlayerModel formatStringToPlayer(String string) {
        return this.converter.fromString(string);
    }

    public List<String> formatListPlayersToListString(List<RacingCarPlayerModel> players) {
        return players.stream().map(this::formatPlayerToString).collect(Collectors.toList());
    }

    public String formatListPlayersToString(List<RacingCarPlayerModel> players) {
        return String.join(COMMA_BLANK, this.formatListPlayersToListString(players));
    }

    public List<RacingCarPlayerModel> formatListStringToListPlayers(List<String> players){
        return players.stream().map(this::formatStringToPlayer).collect(Collectors.toList());
    }
}

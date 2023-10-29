package util.formatter;

import static racingcar.Constants.COMMA;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCarPlayerModel;
import util.stringconverter.RacingCarConverter;

public class RacingCarFormatter extends Formatter {
    final RacingCarConverter converter;

    public RacingCarFormatter() {
        this.converter = new RacingCarConverter();
    }

    public String formatRacingCarPlayerToString(RacingCarPlayerModel player) {
        return this.converter.toString(player);
    }

    public RacingCarPlayerModel formatStringToRacingCarPlayer(String string) {
        return this.converter.fromString(string);
    }

    public List<String> formatListRacingCarPlayersToListString(List<RacingCarPlayerModel> players) {
        return players.stream().map(this::formatRacingCarPlayerToString).collect(Collectors.toList());
    }

    public String formatListRacingCarPlayersToString(List<RacingCarPlayerModel> players) {
        return String.join(COMMA, this.formatListRacingCarPlayersToListString(players));
    }

    public List<RacingCarPlayerModel> formatListStringToListRacingCarPlayer(List<String> players){
        return players.stream().map(this::formatStringToRacingCarPlayer).collect(Collectors.toList());
    }
}

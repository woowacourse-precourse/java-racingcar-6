package util.formatter;

import static racingcar.Constants.COMMA_BLANK;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarPlayerModel;
import util.stringconverter.CarConverter;

public class CarFormatter extends Formatter {
    final CarConverter converter;

    public CarFormatter() {
        this.converter = new CarConverter();
    }

    public String formatPlayerToString(CarPlayerModel player) {
        return this.converter.toString(player);
    }

    public CarPlayerModel formatStringToPlayer(String string) {
        return this.converter.fromString(string);
    }

    public List<String> formatListPlayersToListString(List<CarPlayerModel> players) {
        return players.stream().map(this::formatPlayerToString).collect(Collectors.toList());
    }

    public String formatListPlayersToString(List<CarPlayerModel> players) {
        return String.join(COMMA_BLANK, this.formatListPlayersToListString(players));
    }

    public List<CarPlayerModel> formatListStringToListPlayers(List<String> players) {
        return players.stream().map(this::formatStringToPlayer).collect(Collectors.toList());
    }
}

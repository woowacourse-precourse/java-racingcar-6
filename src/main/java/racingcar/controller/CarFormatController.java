package racingcar.controller;

import java.util.List;
import racingcar.model.CarPlayerModel;
import util.formatter.CarFormatter;

public class CarFormatController {
    private final CarFormatter formatter;

    public CarFormatController() {
        this.formatter = new CarFormatter();
    }

    public String formatCarPlayerToString(CarPlayerModel player) {
        return this.formatter.formatPlayerToString(player);
    }

    public CarPlayerModel formatStringToCarPlayer(String string) {
        return this.formatter.formatStringToPlayer(string);
    }

    public List<String> formatListCarPlayersToListString(List<CarPlayerModel> players) {
        return this.formatter.formatListPlayersToListString(players);
    }

    public String formatListCarPlayersToString(List<CarPlayerModel> players) {
        return this.formatter.formatListPlayersToString(players);
    }

    public List<CarPlayerModel> formatListStringToListCarPlayer(List<String> players) {
        return this.formatter.formatListStringToListPlayers(players);
    }

    public List<CarPlayerModel> formatStringToListCarPlayer(String players) {
        return this.formatter.formatListStringToListPlayers(this.formatter.formatStringToListString(players));
    }
}

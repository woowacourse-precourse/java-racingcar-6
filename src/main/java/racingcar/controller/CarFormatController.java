package racingcar.controller;

import java.util.List;
import racingcar.model.CarPlayerModel;
import util.formatter.CarFormatter;

public class CarFormatController {
    private final CarFormatter formatter;

    public CarFormatController(){
        this.formatter = new CarFormatter();
    }

    public String formatRacingCarPlayerToString(CarPlayerModel player) {
        return this.formatter.formatPlayerToString(player);
    }

    public CarPlayerModel formatStringToRacingCarPlayer(String string) {
        return this.formatter.formatStringToPlayer(string);
    }

    public List<String> formatListRacingCarPlayersToListString(List<CarPlayerModel> players) {
        return this.formatter.formatListPlayersToListString(players);
    }

    public String formatListRacingCarPlayersToString(List<CarPlayerModel> players) {
        return this.formatter.formatListPlayersToString(players);
    }

    public List<CarPlayerModel> formatListStringToListRacingCarPlayer(List<String> players){
        return this.formatter.formatListStringToListPlayers(players);
    }

    public List<CarPlayerModel> formatStringToListRacingCarPlayer(String players){
        return this.formatter.formatListStringToListPlayers(this.formatter.formatStringToListString(players));
    }
}

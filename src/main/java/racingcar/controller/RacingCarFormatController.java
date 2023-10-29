package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCarPlayerModel;
import util.formatter.RacingCarFormatter;

public class RacingCarFormatController {
    private final RacingCarFormatter formatter;

    public RacingCarFormatController(){
        this.formatter = new RacingCarFormatter();
    }

    public String formatRacingCarPlayerToString(RacingCarPlayerModel player) {
        return this.formatter.formatRacingCarPlayerToString(player);
    }

    public RacingCarPlayerModel formatStringToRacingCarPlayer(String string) {
        return this.formatter.formatStringToRacingCarPlayer(string);
    }

    public List<String> formatListRacingCarPlayersToListString(List<RacingCarPlayerModel> players) {
        return this.formatter.formatListRacingCarPlayersToListString(players);
    }

    public String formatListRacingCarPlayersToString(List<RacingCarPlayerModel> players) {
        return this.formatter.formatListRacingCarPlayersToString(players);
    }

    public List<RacingCarPlayerModel> formatListStringToListRacingCarPlayer(List<String> players){
        return this.formatter.formatListStringToListRacingCarPlayer(players);
    }

    public List<RacingCarPlayerModel> formatStringToListRacingCarPlayer(String players){
        return this.formatter.formatListStringToListRacingCarPlayer(this.formatter.formatStringToListString(players));
    }
}

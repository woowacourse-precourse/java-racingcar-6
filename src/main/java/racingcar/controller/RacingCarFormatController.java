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
        return this.formatter.formatPlayerToString(player);
    }

    public RacingCarPlayerModel formatStringToRacingCarPlayer(String string) {
        return this.formatter.formatStringToPlayer(string);
    }

    public List<String> formatListRacingCarPlayersToListString(List<RacingCarPlayerModel> players) {
        return this.formatter.formatListPlayersToListString(players);
    }

    public String formatListRacingCarPlayersToString(List<RacingCarPlayerModel> players) {
        return this.formatter.formatListPlayersToString(players);
    }

    public List<RacingCarPlayerModel> formatListStringToListRacingCarPlayer(List<String> players){
        return this.formatter.formatListStringToListPlayers(players);
    }

    public List<RacingCarPlayerModel> formatStringToListRacingCarPlayer(String players){
        return this.formatter.formatListStringToListPlayers(this.formatter.formatStringToListString(players));
    }
}

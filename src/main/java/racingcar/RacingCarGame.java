package racingcar;

import java.util.ArrayList;
import java.util.List;
import game.Game;
import util.inputreader.RacingCarInputReader;
import util.stringconverter.RacingCarConverter;

public class RacingCarGame implements Game {
    private List<RacingCarPlayer> players;

    private int tryCount;
    private final RacingCarInputReader racingCarInputReader;

    private final RacingCarConverter racingCarConverter;

    public RacingCarGame() {
        this.players = new ArrayList<>();
        this.racingCarInputReader = new RacingCarInputReader();
        this.racingCarConverter = new RacingCarConverter();
    }

    @Override
    public void start() {
    }

    @Override
    public void end() {

    }

    public void setPlayers(){
        List<String> players = racingCarInputReader.inputPlayers();
        players.stream().map(racingCarConverter::fromString).forEach(this.players::add);
    }

    public void setTryCount(){
        this.tryCount = racingCarInputReader.inputTryCount();
    }
}

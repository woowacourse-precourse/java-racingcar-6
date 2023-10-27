package racingcar;

import java.util.ArrayList;
import java.util.List;
import game.Game;
import util.RacingCarRandoms;
import util.inputreader.RacingCarInputReader;
import util.stringconverter.RacingCarConverter;

public class RacingCarGame implements Game {
    private List<RacingCarPlayer> players;

    private int tryCount;
    private final RacingCarInputReader racingCarInputReader;

    private final RacingCarConverter racingCarConverter;

    private final RacingCarRandoms racingCarRandoms;

    public RacingCarGame() {
        this.players = new ArrayList<>();
        this.racingCarInputReader = new RacingCarInputReader();
        this.racingCarConverter = new RacingCarConverter();
        this.racingCarRandoms = new RacingCarRandoms();
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

    public void movePlayers(){
        this.players.forEach(player -> {
            if(this.getRandomNumber() >= 4){
                player.move();
            }
        });
    }
    public int getRandomNumber(){
        return this.racingCarRandoms.getRandomNumber();
    }
}

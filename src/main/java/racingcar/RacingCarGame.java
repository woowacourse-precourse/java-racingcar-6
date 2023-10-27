package racingcar;

import java.util.ArrayList;
import java.util.List;
import game.Game;
import java.util.stream.Collectors;
import util.RacingCarRandoms;
import util.inputreader.RacingCarInputReader;

public class RacingCarGame implements Game {
    private List<RacingCarPlayer> players;

    private List<RacingCarPlayer> winners;

    private int tryCount;

    private final RacingCarInputReader racingCarInputReader;

    private final RacingCarFormatter racingCarFormatter;

    private final RacingCarRandoms racingCarRandoms;

    public RacingCarGame() {
        this.players = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.racingCarInputReader = new RacingCarInputReader();
        this.racingCarFormatter = new RacingCarFormatter();
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
        this.players = players.stream().map(racingCarFormatter::racingCarPlayerFromString).collect(Collectors.toList());
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

    public void printPlayersPosition(){
        this.players.forEach(RacingCarPlayer::printPosition);
    }

    public void judgeWinners(){
        int maxPosition = this.players.stream().mapToInt(RacingCarPlayer::getCurrentPosition).max().orElse(0);
        this.players.forEach(player -> {
            if(player.getCurrentPosition() == maxPosition){
                this.winners.add(player);
            }
        });
    }

    public void printWinners(){
        System.out.print("최종 우승자 : ");
        System.out.println(this.racingCarFormatter.racingCarPlayersToString(this.winners));
        System.out.println();
    }
}

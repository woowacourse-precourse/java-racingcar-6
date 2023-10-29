package racingcar;

import java.util.ArrayList;
import java.util.List;
import game.Game;
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
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        this.setPlayers();
        System.out.println("시도할 회수는 몇회인가요?");
        this.setTryCount();
        System.out.println();
        while(this.tryCount > 0){
            this.movePlayers();
            this.printPlayersPosition();
            System.out.println();
            this.tryCount--;
        }
        this.end();
    }

    @Override
    public void end() {
        this.judgeWinners();
        this.printWinners();
    }

    public void setPlayers(){
        List<String> players = racingCarInputReader.inputPlayers();
        this.players = this.racingCarFormatter.formatListStringToListRacingCarPlayer(players);
    }

    public void setTryCount(){
        this.tryCount = racingCarInputReader.inputTryCount();
    }

    public void movePlayers(){
        this.players.forEach(player -> {
            if(this.isPlayerCanMove(this.getRandomNumber())){
                player.move();
            }
        });
    }

    public boolean isPlayerCanMove(int randomNumber){
        return randomNumber >= 4;
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
        System.out.println(this.racingCarFormatter.formatListRacingCarPlayersToString(this.winners));
        System.out.println();
    }
}

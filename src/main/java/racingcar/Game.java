package racingcar;

public class Game {
    final int playNum;
    final Car[] players;

    Game(String[] carNames, int playNum) {
        this.playNum = playNum;
        players = new Car[carNames.length];
        for(int i=0; i<carNames.length; i++){
            this.players[i] = new Car(carNames[i]);
        }
    }
    public void play(){
        NumberGenerator ng = new NumberGenerator();
        for (int i=0; i<players.length; i++){
            int num = ng.createNumber();
            if(ng.compareBigger(4, num)){players[i].move(1);}
        }
    }
}

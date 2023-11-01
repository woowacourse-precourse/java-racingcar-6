package racingcar;

import racingcar.game.RacingGame;

public class Application {
    public static void main(String[] args) {
        try{
            RacingGame.play();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}

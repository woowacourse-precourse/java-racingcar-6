package racingcar;
import java.util.ArrayList;

import car.Car;
import game.*;

public class Application {
    public static void main(String[] args) {
    	//게임준비
        ArrayList<Car> GameReady = Game.gameReady();
        //게임시작
        Game.gameStart(Game.gameTRYCount(), GameReady);
        //우승자(엔딩)
        Game.gameWinner(GameReady);
    }
}

package racingcar;
import java.util.ArrayList;

import car.Car;
import game.*;

public class Application {
    public static void main(String[] args) {
    	//게임준비
        ArrayList<Car> carListForGameReady = Game.gameReady();
        int player_input_gameTRY = Game.gameTRYCount();
        //게임시작
        Game.gameStart(player_input_gameTRY, carListForGameReady);
        //우승자(엔딩)
        Game.gameWinner(carListForGameReady);
    }
}

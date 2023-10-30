package racingcarGame;

import java.util.ArrayList;
import java.util.List;

import static constant.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    List<String> carNames = new ArrayList<>();

    public Game(){

    }

    public static void run(){
        Game game;
        game = new Game();
        game.gameStart();
    }

    private void gameStart(){
        inputCarNames();
    }

    private void inputCarNames(){
        String inputString = Console.readLine();
        String[] inputStringArr = inputString.split(",");
        int arrLength = inputStringArr.length;
        if(arrLength > 5){
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
        for(int i = 0; i < arrLength; i++) {
            carNames.add(inputStringArr[i]);
        }
        for(String name : carNames){
                System.out.println(name);
        }
    }
}

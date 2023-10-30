package racingcarGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        inputNumber();
    }

    private void inputCarNames(){
        System.out.println(INPUT_CAR_NAMES);
        String inputString = Console.readLine();
        String[] inputStringArr = inputString.split(",");
        int arrLength = inputStringArr.length;
        if(arrLength > 5){
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
        Set<String> carNameSet = new HashSet<>();
        for(int i = 0; i < arrLength; i++) {
            carNames.add(inputStringArr[i]);
        }
        for(String carName : carNames){
            if(carNameSet.contains(carName)){
                throw new IllegalArgumentException(WRONG_INPUT_DUPLICATION);
            }
            carNameSet.add(carName);
//                System.out.println(name);
        }
//        for (String carName : carNameSet) {
//            System.out.println(carName);
//        }
    }

    private void inputNumber(){
        System.out.println(INPUT_NUMBER);
        String inputNumString = Console.readLine();
        int inputNum = 0;
        try {
            inputNum = Integer.parseInt(inputNumString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
}

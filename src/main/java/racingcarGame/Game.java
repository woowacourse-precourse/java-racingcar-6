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
    int carNumber;
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
        carNumber = inputStringArr.length;
        Set<String> carNameSet = new HashSet<>();
        for(int i = 0; i < carNumber; i++) {
            if(inputStringArr[i].length() > 5){
                throw new IllegalArgumentException(WRONG_INPUT_SIZE);
            }
            carNames.add(inputStringArr[i]);
        }
        for(String carName : carNames){
            if(carNameSet.contains(carName)){
                throw new IllegalArgumentException(WRONG_INPUT_DUPLICATION);
            }
            carNameSet.add(carName);
        }
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
        racing(inputNum);
    }

    private void racing(int inputNum){
        int[] tryNumber = new int[3];

        for(int i = 0; i < inputNum; i++){ // 총 5번 반복
            racingOnce(tryNumber);
//            printRanking(trynumber);

//            System.out.println();
        }
    }

    private void racingOnce(int[] tryNumber){
//        System.out.println("racingOnce함수");
        for(int i = 0; i < carNumber; i++){
            int randomNum = getRandomNum();
            System.out.println(randomNum);
            if(randomNum >= 4){
                tryNumber[i]++;
            }
            System.out.println("이번 넘버 : "+tryNumber[i]);
        }

    }
    private int getRandomNum(){
//        System.out.println("랜덤넘버 실행");
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
}

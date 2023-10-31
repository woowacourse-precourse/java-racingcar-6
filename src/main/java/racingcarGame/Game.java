package racingcarGame;

import java.util.*;

import static constant.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private Map<String, Integer> carData = new HashMap<>();
    int carNumber;

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
        for(int i = 0; i < carNumber; i++) {
            if(inputStringArr[i].length() > 5){
                throw new IllegalArgumentException(WRONG_INPUT_SIZE);
            }
            if(carData.containsKey(inputStringArr[i])){
                throw new IllegalArgumentException(WRONG_INPUT_DUPLICATION);
            }
            carData.put(inputStringArr[i], 0);
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
        System.out.println(RESULT);
        for(int i = 0; i < inputNum; i++){ // 총 5번 반복
            racingOnce();
            printRanking();

            System.out.println();
        }
        printWinner();

    }

    private void printWinner(){
        List<String> maxCarNames = new ArrayList<>();
        int maxValue = 0;
        for(Map.Entry<String, Integer> entry : carData.entrySet()) {
            int value = entry.getValue();
            if(value > maxValue){
                maxValue = value;
                maxCarNames.clear();
                maxCarNames.add(entry.getKey());
            } else if(value == maxValue){
                maxCarNames.add(entry.getKey());
            }
        }
        System.out.print(FINAL_WINNER);
        for (int i = 0; i < maxCarNames.size(); i++) {
            String carName = maxCarNames.get(i);
            System.out.print(carName);
            if (i < maxCarNames.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private void printRanking(){
        int curCarNum = 0;
        for(Map.Entry<String, Integer> entry : carData.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            System.out.print("-".repeat(entry.getValue()));
            System.out.println();
        }
    }

    private void racingOnce(){
        for(Map.Entry<String, Integer> entry : carData.entrySet()){
            String carName = entry.getKey();
            int value = entry.getValue();
            int randomNum = getRandomNum();
            if(randomNum >= 4){
                value++;
            }
            carData.put(carName, value);
        }
    }

    private int getRandomNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
}

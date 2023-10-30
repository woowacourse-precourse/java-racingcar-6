package racingcarGame;

import java.util.*;

import static constant.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    List<String> carNames = new ArrayList<>();
    Set<String> carNameSet = new HashSet<>();
    private Map<String, Integer> carData = new HashMap<>();
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
        for(int i = 0; i < carNumber; i++) {
            if(inputStringArr[i].length() > 5){
                throw new IllegalArgumentException(WRONG_INPUT_SIZE);
            }
            if(carData.containsKey(inputStringArr[i])){
                throw new IllegalArgumentException(WRONG_INPUT_DUPLICATION);
            }
            carData.put(inputStringArr[i], 0);
//            carNames.add(inputStringArr[i]);
        }
//        for(String carName : carNames){
//            if(carNameSet.contains(carName)){
//                throw new IllegalArgumentException(WRONG_INPUT_DUPLICATION);
//            }
//            carNameSet.add(carName);
//        }
    }

//    public void addCar(String )

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
            printRanking(tryNumber);

            System.out.println();
        }
        printWinner(tryNumber);

    }

    private void printWinner(int[] tryNumber){
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
//        for(String carName : maxCarNames) {
//            System.out.print(carName + ", ");
//        }
    }

    private void printRanking(int[] tryNumber){
//        for(int i = 0; i < carNumber; i++){
//            System.out.print(carNameSet[i]);
//        }
        System.out.println(RESULT);
        int curCarNum = 0;
        for(Map.Entry<String, Integer> entry : carData.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            System.out.print("-".repeat(entry.getValue()));
            System.out.println();

//            System.out.println(tryNumber[curCarNum++]);
        }
    }

    private void racingOnce(int[] tryNumber){
//        System.out.println("racingOnce함수");
        for(Map.Entry<String, Integer> entry : carData.entrySet()){
            String carName = entry.getKey();
            int value = entry.getValue();
            int randomNum = getRandomNum();
            if(randomNum >= 4){
                value++;
            }
            carData.put(carName, value);
        }

//        for(int i = 0; i < carNumber; i++){
//            int randomNum = getRandomNum();
////            System.out.println(randomNum);
//            if(randomNum >= 4){
//                tryNumber[i]++;
//            }
////            System.out.print("".repeat(tryNumber[i]));
//        }

    }
    private int getRandomNum(){
//        System.out.println("랜덤넘버 실행");
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
}

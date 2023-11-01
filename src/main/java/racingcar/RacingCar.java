package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {

    Map<String, String> playersMap = new HashMap<>();
    List<String> winnerList = new ArrayList<>();

    //입력 분할
    public String[] splitCarsName(String input){

        return input.split(",");
    }

    //자동차 이름 입력 예외
    public void checkCarsNameLength(String[] cars) {

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void saveCars(String[] cars) {

        for (String car : cars) {
            playersMap.put(car, "");
        }
    }

    public void initPlayer(String input){
        String [] cars = splitCarsName(input);
        checkCarsNameLength(cars);
        saveCars(cars);
    }

    public Integer checkRoundsInput(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getRandomValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void judgeMoveOrStop(String car, int moveOrStop){
        if (moveOrStop >= 4) {
            String roundResult = new StringBuilder(playersMap.get(car)).append("-").toString();
            playersMap.put(car, roundResult);
        }
    }

    public void printRoundResult() {

        StringBuilder sb = new StringBuilder();
        for (String player : playersMap.keySet()) {
            sb.append(player).append(" : ").append(playersMap.get(player)).append("\n");
        }

        System.out.println(sb);
    }

    public void play(){
        for(String car : playersMap.keySet()){
            int moveOrStop = getRandomValue();
            judgeMoveOrStop(car, moveOrStop);
        }
        printRoundResult();
    }

    public int getMaxValue() {

        int max = 0;
        for (String player : playersMap.values()) {
            int result = player.length();
            if (max < result) {
                max = result;
            }
        }

        return max;
    }

    public void getWinner(int max) {

        for (String player : playersMap.keySet()) {
            int roundResultLength = playersMap.get(player).length();
            if (roundResultLength == max) {
                winnerList.add(player);
            }
        }
    }
    public void endGame(){
        int valueOfWinner = getMaxValue();
        getWinner(valueOfWinner);

    }


    public void run(){
        System.out.println(Notification.inputCarsName);
        initPlayer(Console.readLine());

        System.out.println(Notification.inputNumOfRounds);
        int numOfRounds = checkRoundsInput(Console.readLine());

        System.out.println(Notification.result);
        for (int i = 0; i < numOfRounds; i++) {
            play();
        }

        endGame();
    }
}

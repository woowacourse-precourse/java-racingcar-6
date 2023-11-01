package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {

    Map<String, String> carsMap = new HashMap<>();
    List<String> winnerList = new ArrayList<>();

    public void run(){
        System.out.println(Notification.inputCarsName);
        initCar(Console.readLine());

        System.out.println(Notification.inputNumOfRounds);
        int numOfRounds = checkRoundsInput(Console.readLine());

        System.out.println(Notification.result);
        for (int i = 0; i < numOfRounds; i++) {
            play();
        }

        endGame();
    }

    public void initCar(String input){
        String [] cars = splitCarsName(input);
        checkCarsNameLength(cars);
        saveCars(cars);
    }

    public void play(){
        for(String car : carsMap.keySet()){
            int moveOrStop = getRandomValue();
            judgeMoveOrStop(car, moveOrStop);
        }
        printRoundResult();
    }

    public void endGame(){
        int valueOfWinner = getMaxValue();
        getWinner(valueOfWinner);
        printWinner();
    }


    //입력 분할
    public String[] splitCarsName(String input){

        return input.split(",");
    }

    //자동차 이름 입력 예외
    public void checkCarsNameLength(String[] cars) {

        for (String car : cars) {
            if (car.length() > 5 || car.trim().length() < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    //자동차 이름 저장
    public void saveCars(String[] cars) {

        for (String car : cars) {
            carsMap.put(car, "");
        }
    }

    //움직일 횟수 입력
    public Integer checkRoundsInput(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    //랜덤값 추출
    public int getRandomValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

    //전진 여부 판단
    public void judgeMoveOrStop(String car, int moveOrStop){
        if (moveOrStop >= 4) {
            String roundResult = new StringBuilder(carsMap.get(car)).append("-").toString();
            carsMap.put(car, roundResult);
        }
    }

    //라운드 결과 출력
    public void printRoundResult() {

        StringBuilder sb = new StringBuilder();
        for (String player : carsMap.keySet()) {
            sb.append(player).append(" : ").append(carsMap.get(player)).append("\n");
        }

        System.out.println(sb);
    }

    //가장 많이 움직인 횟수 구하기
    public int getMaxValue() {

        int max = 0;
        for (String player : carsMap.values()) {
            int result = player.length();
            if (max < result) {
                max = result;
            }
        }

        return max;
    }

    //우승자 판단
    public void getWinner(int max) {

        for (String player : carsMap.keySet()) {
            int roundResultLength = carsMap.get(player).length();
            if (roundResultLength == max) {
                winnerList.add(player);
            }
        }
    }

    //결과 출력
    public void printWinner() {
        StringBuilder sb = new StringBuilder(Notification.winners);
        int i;
        for (i = 0; i < winnerList.size() - 1; i++) {
            sb.append(winnerList.get(i)).append(", ");
        }

        sb.append(winnerList.get(i));

        System.out.println(sb);
    }

}

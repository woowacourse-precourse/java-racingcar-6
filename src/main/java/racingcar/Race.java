package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    Map<String, String> scorePerCar = new HashMap<>();
    int tryNum;
    List<String> winCars = new ArrayList<>();
    
    public void initScorePerCar(String[] carArray) {
        for (String car : carArray) {
            scorePerCar.put(car, "");
        }
    }
    
    public void enterRaceNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요!");
        }
    }
    
    public void raceProgress() {
        for (int i = 0; i < tryNum; i++) {
            moveOrStop();
            printResultPerTry();
        }
    }
    
    public void findWinner() {
        int maxDistance = getMaxDistance();
    
        for (String scorePerCarKey : scorePerCar.keySet()) {
            if (scorePerCar.get(scorePerCarKey).length() == maxDistance) {
                winCars.add(scorePerCarKey);
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winCars));
    }
    
    private int getMaxDistance() {
        int maxDistance = -1;
        for (String scorePerCarKey : scorePerCar.keySet()) {
            String distance = scorePerCar.get(scorePerCarKey);//마지막에 각 키에 따른 밸류 길이 비교
            if (distance.length() > maxDistance) {
                maxDistance = distance.length();
            }
        }
        return maxDistance;
    }
    
    
    private void moveOrStop() {
        for (String scorePerCarKey : scorePerCar.keySet()) {
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                scorePerCar.replace(scorePerCarKey, scorePerCar.get(scorePerCarKey) + "-");//전진
            }
        }
    }
    
    private void printResultPerTry() {
        System.out.println("실행 결과");
        for (String scorePerCarKey : scorePerCar.keySet()) {
            System.out.println(scorePerCarKey + " : " + scorePerCar.get(scorePerCarKey));
        }
    }
}

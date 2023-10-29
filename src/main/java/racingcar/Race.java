package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Race {
    Map<String, String> scorePerCar = new HashMap<>();
    int tryNum;
    
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

package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
    
}

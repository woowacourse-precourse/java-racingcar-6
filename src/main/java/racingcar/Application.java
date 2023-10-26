package racingcar;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carArray = Console.readLine().split(",");
        if (carArray.length < 1){
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해주세요!");
        }
        
        for (String car : carArray) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 합니다!");
            }
        }
        
        HashMap<String, Integer> scorePerCar = new HashMap<>();
        for (String car : carArray) {
            scorePerCar.put(car, 0);
        }
        
        
    }
}

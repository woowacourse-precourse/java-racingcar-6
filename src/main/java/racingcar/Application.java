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
        
        HashMap<String, String> scorePerCar = new HashMap<>();
        for (String car : carArray) {
            scorePerCar.put(car, "");
        }
        
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum;
        try {
            tryNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요!");
        }
    
        for (int i = 0; i < tryNum; i++) {
            moveOrStop(scorePerCar);
            printResult(scorePerCar);
        }
        
    }
    
    private static void moveOrStop(HashMap<String, String> scorePerCar) {
        for (String scorePerCarKey : scorePerCar.keySet()) {
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                scorePerCar.replace(scorePerCarKey, scorePerCar.get(scorePerCarKey) + "-");//전진
            }
        }
    }
    
    private static void printResult(HashMap<String, String> scorePerCar) {
        System.out.println("실행 결과");
        for (String scorePerCarKey : scorePerCar.keySet()) {
            System.out.println(scorePerCarKey + " : " + scorePerCar.get(scorePerCarKey));
        }
    }
    
}

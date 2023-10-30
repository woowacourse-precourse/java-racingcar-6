package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class PlayStart {
    public static void carNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        HashMap<Object, Integer> positionHashMap = new HashMap<>();
        for (String carName: carNames) {
            Car car = new Car(carName);
            positionHashMap.put(car,1);
        }
        System.out.println(positionHashMap);
    }
    public static void roundNumberInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        String roundNum = Console.readLine();
        try{
            Integer.parseInt(roundNum);
        }catch (Exception e){
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
        int roundNumber = Integer.parseInt(roundNum);
    }
}

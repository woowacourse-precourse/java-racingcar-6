package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RacingGame {

    public void start(){
        String carList = inputCarList();
        CarMap carMap = new CarMap(carList);
        int times = inputTryTimes();
        playGame(carMap, times);
    }

    public String inputCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int inputTryTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        String times = Console.readLine();
        if(validateTryTimes(times)) return Integer.parseInt(times);
        return 0;
    }

    public boolean validateTryTimes(String times){
        try{
            Integer.parseInt(times);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public void playGame(CarMap carMap, int times){
        for(int i = 0; i < times; i++){
            moveCar(carMap);
        }
        printResult(carMap);
    }

    public boolean isGone(){
        int random = Randoms.pickNumberInRange(0,9);
        return random >= 4;
    }

    public void moveCar(CarMap carMap){
        Map<String,String> racingMap = carMap.getMap();
        Set<String> racingSet = racingMap.keySet();
        for (String key : racingSet) {
            if(isGone()) {
                carMap.go(key);
            }
        }
        printRacingSituation(carMap);
    }

    public void printRacingSituation(CarMap carMap){
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
        Set<String> racingSet = carMap.getKeySet();
        for (String key : racingSet) {
            if(isGone()) carMap.go(key);
        }
        printRacingSituation(carMap);
    }

    public void printRacingSituation(CarMap carMap){
        Set<String> racingSet = carMap.getKeySet();
        for (String key : racingSet) {
            System.out.println(key + " : " + carMap.getMap().get(key));
        }
        System.out.println();
    }

    public void printResult(CarMap carMap){
        int firstScore = getFirstScore(carMap);
        String result = getResultString(carMap, firstScore);
        System.out.println(result);
    }

    public int getFirstScore(CarMap carMap){
        LinkedHashMap<String, String> racingMap = carMap.getMap();
        Set<String> racingSet = carMap.getKeySet();
        List<Integer> racingScore = new ArrayList<>();
        for (String key : racingSet){
            String value = racingMap.get(key);
            racingScore.add(value.length());
        }
        Collections.sort(racingScore);
        return racingScore.get(racingScore.size()-1);
    }

    public String getResultString(CarMap carMap, int firstScore){
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (String key : carMap.getKeySet()){
            String value = carMap.getMap().get(key);
            if(value.length() == firstScore) sb.append(key).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()-1);
        return sb.toString();
    }
}

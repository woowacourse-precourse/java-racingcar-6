package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String cars = readLine();
        List<String> carList = List.of(cars.split(","));

        Map<String, Integer> carMap = carList.stream()
                .collect(Collectors.toMap(key -> key, value -> 0));

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(readLine());

        for(int i=0;i<tryNumber;i++){
            printRacingState(carMap);
        }


        Integer maxvalue = carMap.get(Collections.max(carMap.entrySet(), Comparator.comparingInt(Map.Entry :: getValue)).getKey());

        List<String> winnerList = carMap.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), maxvalue))
                .map(Map.Entry::getKey)
                .toList();

        String winners = String.join(", ", winnerList);
        System.out.print("최종 우승자 : "+ winners);


    }

    static void printRacingState(Map<String, Integer> carMap){

        for(String key : carMap.keySet()){
            System.out.print(key + " : ");
            if(Randoms.pickNumberInRange(0,9)>=4){
                carMap.put(key, carMap.get(key)+1);
            }
            for(int i=0;i< carMap.get(key);i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}

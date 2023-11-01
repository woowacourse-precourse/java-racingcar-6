package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String cars = readLine();
        List<String> carList = List.of(cars.split(","));
        int maxLength = 5;

        if(isCarnameTooLong(carList, maxLength)){
            throw new IllegalArgumentException();
        }

        Map<String, Integer> carMap = carList.stream()
                .collect(Collectors.toMap(key -> key, value -> 0));

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(readLine());

        for(int i=0;i<tryNumber;i++){
            printRacingState(carMap);
        }

        System.out.print("최종 우승자 : "+ decideWinners(carMap));

    }

    public static boolean isCarnameTooLong(List<String> carList, int maxLength){
        return carList.stream()
                .anyMatch(it -> it.length()>maxLength);
    }

    public static void printRacingState(Map<String, Integer> carMap){

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

    public static String decideWinners(Map<String, Integer> resultMap) {
        Integer maxValue = resultMap.get(
            Collections.max(resultMap.entrySet(),
                Comparator.comparingInt(Map.Entry :: getValue))
                .getKey()
        );

        List<String> winnerList = resultMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxValue))
                .map(Map.Entry::getKey)
                .toList();

        return String.join(", ", winnerList);
    }
}

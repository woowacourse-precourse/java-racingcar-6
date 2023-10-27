package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String cars = readLine();
        List<String> carList = List.of(cars.split(","));

        Map<String, String> carMap = carList.stream()
                .collect(Collectors.toMap(key -> key, value -> ""));

        System.out.println(carMap);
        System.out.println(carMap.size());

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(readLine());

        for(int i=0;i<tryNumber;i++){
            printRacingState(carMap);
        }

    }

    static void printRacingState(Map<String, String> carMap){

        for(String key : carMap.keySet()){
            System.out.print(key + " : ");
            if(Randoms.pickNumberInRange(0,9)>=4){
                carMap.put(key, carMap.get(key)+"-");
            }
            System.out.println(carMap.get(key));
        }
        System.out.println();
    }
}

package racingcar;

import static racingcar.constants.GO_RANDOM_NUMBER;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameController {
    public void start(){
        List<String> carsList = setCars();
        int round = setRound();
        System.out.println("");
        System.out.println("실행 결과");

        Map<String, String> carsMap = new LinkedHashMap<>();
        for (String car : carsList) {
            carsMap.put(car, "");
        }

        for (int i = 0; i < round; i++) {

            printLocate(carsMap);
            System.out.println();
        }

        printWinner(carsMap);
    }
    private List<String> setCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = Car.sortCarName();
        return carNameList;
    }

    private int setRound(){
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int round = Round.getRound();
        System.out.println(round);
        return round;
    }

    private static void printLocate(Map<String, String> carsMap) {

        for (String car : carsMap.keySet()) {

            int random = RandomNumber.getRandomNumber();
            RandomNumber.locate(random);
            if (random >= GO_RANDOM_NUMBER) {
                String result = carsMap.get(car) + "-";
                carsMap.put(car, result);
            }
            System.out.println(car + " : " + carsMap.get(car));
        }

    }


    private static void printWinner(Map<String, String> carsMap) {
        String winner = "";
        int length = 0;
        for (String car : carsMap.keySet()) {

            if (carsMap.get(car).length() > length) {
                length = carsMap.get(car).length();
                winner = car;
            }

            if (carsMap.get(car).length() == length && !car.equals(winner)) {
                if (!winner.isEmpty()) {
                    winner += ", ";
                }
                winner += car;
            }

        }
        System.out.println("최종 우승자 : " + winner);
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static Race race;

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> racingCars = new LinkedHashMap<String, Integer>();
        race = new Race(racingCars);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        String[] cars = input.split(",");
        racingCarNameCheck(cars);
        race.racingCarInit(cars);
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(readLine());
        System.out.println();
        System.out.println("실행 결과");
        race.raceStart(gameCount);
        int max = racingCarsMaxValue();
        String winners = whoWinner(max);
        System.out.println("최종 우승자 : " + winners);
    }

    /*
     * 자동차의 이름이 5자 이하인지 확인하는 함수입니다. 
     */
    public static void racingCarNameCheck(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해주세요");
        }
    }

    /*
     * 현재 자동차 중의 가장 높은 값을 파라미터를 받고 
     * 가장 멀리 간 자동차의 데이터를 반환해줍니다. 
     */
    public static String whoWinner(int max) {
        ArrayList<String> resRacing = new ArrayList<>();
        String winners = "";

        for (Map.Entry<String, Integer> car : race.racingCars.entrySet()) {
            if (max == car.getValue()) {
                resRacing.add(car.getKey());
            }
        }
        winners = String.join(",", resRacing);
        return winners;
    }
    // 자동차들 중에서 가장 멀리간 자동차의 값을 리턴 해줍니다. 
    public static int racingCarsMaxValue() {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> car : race.racingCars.entrySet()) {
            max = Math.max(max, car.getValue());
        }
        return max;
    }
}

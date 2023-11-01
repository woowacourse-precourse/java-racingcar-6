package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    static Map<String,Integer> cars = new HashMap<>();
    static int gameCount;
    public static void main(String[] args)  {

        inputCars();
        inputGameCount();
        racingGame();
        printGameResult();
    }
    static void inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            checkName(carName);
            cars.put(carName,0);
        }
    }
    static void checkName(String name){
        if(name.length()>5) throw new IllegalArgumentException();
    }
    static void inputGameCount(){
        System.out.println("시도할 횟수는 몇회인가요?");
        gameCount = Integer.parseInt(Console.readLine());
    }

    static int makeRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
    static boolean isProgress(){
        int randomNum = makeRandomNumber();
        if(randomNum>=4) return true;
        else return false;
    }
    static void racingGame(){
        for (int i = 0; i < gameCount; i++) {
            carProgressing();
        }
    }
    static void carProgressing(){
        for (String car : cars.keySet()) {
            if (isProgress())
                cars.put(car,cars.get(car)+1);
        }
        printRacingGame();
    }
    static String progressLevel(int count){
        return "-".repeat(count);
    }
    static void printRacingGame(){
        System.out.println("실행 결과");

        for (String car : cars.keySet()) {
            String level = progressLevel(cars.get(car));
            System.out.println(car+" : "+level);
        }
        System.out.println();
    }

    // 결과를 위한 메서드
    static int findMaxValue(Map<String, Integer> cars) {
        int max = Integer.MIN_VALUE;
        for (Integer value : cars.values()) {
            if(value > max) max = value;
        }
        return max;
    }
    static List<String> findCarsWithMaxValue(Map<String,Integer> cars, int max) {
        List<String> winners = new ArrayList<>();

        for (String car : cars.keySet()) {
            if (cars.get(car) == max) winners.add(car);
        }
        return winners;
    }
    static void printGameResult(){
        int maxValue = findMaxValue(cars);
        List<String> winners = findCarsWithMaxValue(cars, maxValue);

        String result = String.join(",", winners);
        System.out.print("최종 우승자 : "+result);
    }
}

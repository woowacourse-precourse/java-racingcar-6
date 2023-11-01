package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    static Map<String,Integer> cars = new HashMap<>();
    static int gameCount;
    public static void main(String[] args)  {

        // 자동차와 시도 횟수를 입력받는 기능
        inputCars();
        inputGameCount();

        System.out.println("실행 결과");
        //난수 생성 및 자동차 경주 기능
        // 실행결과
        racingGame();





        // 게임종료, 우승자 발표

    }
    public void inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        while (st.hasMoreTokens()) {
            cars.put(st.nextToken(),0);
        }
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
        for (String car : cars.keySet()) {
            String level = progressLevel(cars.get(car));
            System.out.println(car+" : "+level);
        }
        System.out.println();
    }

}

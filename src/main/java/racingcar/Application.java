package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    static Map<String,String> cars = new HashMap<>();
    static int gameCount;
    public static void main(String[] args)  {

        // 자동차와 시도 횟수를 입력받는 기능
        inputCars();
        inputGameCount();

        //난수 생성 및 자동차 경주 기능
        System.out.println("실행 결과");

    }
    static void inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        while (st.hasMoreTokens()) {
            cars.put(st.nextToken(),"");
        }
    }
    static void inputGameCount(){
        System.out.println("시도할 횟수는 몇회인가요?");
        int number = Integer.parseInt(Console.readLine());
    }

    static int makeRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
    static boolean isProgress(){
        int randomNum = makeRandomNumber();
        if(randomNum>=4) return true;
        else return false;
    }
}

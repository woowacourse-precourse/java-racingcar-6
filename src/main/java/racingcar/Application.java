package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args)  {

        // 자동차와 시도 횟수를 입력받는 기능
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        Map<String,String> cars = new HashMap<>();
        while (st.hasMoreTokens()) {
            cars.put(st.nextToken(),"");
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int number = Integer.parseInt(Console.readLine());

    }
}

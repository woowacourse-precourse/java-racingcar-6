package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void isMove(List<Integer> carsMovingDistance, int index) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carsMovingDistance.set(index, carsMovingDistance.get(index) + 1);
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Arrays.asList(camp.nextstep.edu.missionutils.Console.readLine().split(","));
        List<Integer> carsMovingDistance = new ArrayList<>();
        System.out.println("시도할 회수는 몇회인가요?");
        int testNumber = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        System.out.println("\n실행결과");

        while (testNumber > 0) {
            for (int i = 0; i < cars.size(); i++) {
                isMove(carsMovingDistance, i);
                System.out.print(cars.get(i) + " : ");
                System.out.println();
            }
            testNumber--;
        }
    }
}
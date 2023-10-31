package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputCarsName;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarsName = Console.readLine();

        Car cars = new Car();
        String[] carNameArr;
        carNameArr = cars.correctCarName(inputCarsName);
        //각 자동차 이름과
        //각 자동차 전진횟수를 리스트로 선언 -> "-"를 담는 리스트와 회수 count 리스트를 별도로 생성
        List<String> carNameList = new ArrayList<>(Arrays.asList(carNameArr));
        List<String> forwardCountStr = new ArrayList<>();
        List<Integer> forwardCountInt = new ArrayList<>();
        //전진횟수를 모두 ""으로 초기화
        for (int i = 0; i < carNameArr.length; i++) {
            forwardCountStr.add("");
        }
        //전진횟수를 모두 0으로 초기화
        for (int i = 0; i < carNameArr.length; i++) {
            forwardCountInt.add(0);
        }

        String attempt;
        System.out.println("시도할 회수는 몇회인가요?");
        attempt = Console.readLine();

        System.out.println("\n실행 결과");
        for (int i = 0; i < Integer.parseInt(attempt); i++) {
            //n회 시도 - 자동차 수 만큼 반복
            for (int j = 0; j < carNameList.size(); j++) {
                //전진
                if (Randoms.pickNumberInRange(0, 9) > 3) {
                    forwardCountStr.set(j, forwardCountStr.get(j) + "-");
                    forwardCountInt.set(j, forwardCountInt.get(j) + 1);
                }
            }
            for (int k = 0; k < carNameList.size(); k++) {
                System.out.println(String.format("%s : %s", carNameList.get(k), forwardCountStr.get(k)));
            }
            System.out.print("\n");
        }

        System.out.println("최종 우승자 : ");
    }
}

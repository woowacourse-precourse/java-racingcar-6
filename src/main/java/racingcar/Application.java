package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.internal.matchers.Null;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        //입력 1. 경주할 자동차 이름 2. 시도할 횟수
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        //이름이 5자 이하여야함. 아닐경우 IllegalArgumentException 발생
        for(int i = 0; i < carNames.size(); i++) {
            if(carNames.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
            if(carNames.get(i).isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
        List<Integer> carForward = new ArrayList<Integer>(Collections.nCopies(carNames.size(), 0));
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycleNumber = Integer.parseInt(Console.readLine());
        if(cycleNumber == 0) {
            throw new IllegalArgumentException();
        }

        //실행 알고리즘 + 출력 결과(cycle별)
        System.out.println("실행 결과");
        for(int i = 0; i < cycleNumber; i++) {
            processPerCycle(carNames, carForward);
        }

        finalResult(carNames, carForward);

    }

    private static void processPerCycle(List<String> cars, List<Integer> forwards) {
        for(int j = 0; j < cars.size(); j++) {
            System.out.print(cars.get(j) + " : ");
            //자동차별
            int currentForward = forwards.get(j);
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                //전진 +1
                forwards.set(j, currentForward +1);
                System.out.println("-".repeat(currentForward + 1));
            }
            else {
                System.out.println("-".repeat(currentForward));
            }
        }
    }

    private static void finalResult(List<String> cars, List<Integer> forwards) {
        System.out.print("최종 우승자 : ");
        int carMax = Collections.max(forwards);
        int carCount = 0;
        for(int i = 0; i < forwards.size(); i++) {
            //가장 큰 car 찾기
            if(carMax == forwards.get(i) && carCount == 0) {
                System.out.print(cars.get(i));
                carCount++;
            }
            else if(carMax == forwards.get(i) && carCount != 0) {
                System.out.print(", " + cars.get(i));
                carCount++;
            }
        }
    }
}

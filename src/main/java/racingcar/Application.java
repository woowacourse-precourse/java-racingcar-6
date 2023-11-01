package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        }
        List<Integer> carForward = new ArrayList<Integer>(Collections.nCopies(carNames.size(), 0));
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycleNumber = Integer.parseInt(Console.readLine());

        //실행 알고리즘 + 출력 결과(cycle별)
        System.out.println("실행 결과");
        for(int i = 0; i < cycleNumber; i++) {
            //전체 반복 횟수
            for(int j = 0; j < carNames.size(); j++) {
                System.out.print(carNames.get(j) + " : ");
                //자동차별
                int currentForward = carForward.get(j);
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    //전진 +1
                    carForward.set(j, currentForward +1);
                    System.out.println("-".repeat(currentForward + 1));
                }
                else {
                    System.out.println("-".repeat(currentForward));
                }
            }
        }

        System.out.print("최종 우승자 : ");
        int carMax = Collections.max(carForward);
        for(int i = 0; i < carForward.size(); i++) {
            //가장 큰 car 찾기
            if(carMax == carForward.get(i)) {
                System.out.print(carNames.get(i) + " ");
            }
        }
    }
}

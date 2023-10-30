package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    ArrayList<Car> carArrayList = new ArrayList<>();
    Integer count = 0;

    public void start() {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 몇대까지 가능하게 할 것인가?
        String[] nameList = input.split(",");
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
            carArrayList.add(new Car(s, 0));
        }

        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        // 몇대까지 가능하게 할 것인가?
        this.count = Integer.parseInt(input);
        System.out.println(this.count);

        // 실행 결과 출력
        for (int i = 0; i < this.count; i++) {
            for (int j = 0; j < this.carArrayList.size(); j++) {
                int temp = Randoms.pickNumberInRange(0, 9);
                if (temp >= 4) {
                    this.carArrayList.get(j).distance++;
                }
                String result = "-".repeat(this.carArrayList.get(j).distance);
                System.out.println(this.carArrayList.get(j).name + " : " + result);
            }
            System.out.println();
        }


    }
}


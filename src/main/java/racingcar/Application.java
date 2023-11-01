package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //자동차 이름과 회수 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        String[] splited = str.split(",");
        if (splited.length == 0 || splited.length > 5) {
            throw new IllegalArgumentException();
        }
        List<Racing> racings = new ArrayList();
        for (int i = 0; i < splited.length; i++) {
            racings.add(new Racing(splited[i]));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count = 0;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.println("\n실행 결과");
            } else {
                System.out.println();
            }
            for (Racing racing : racings) {
                racing.moveCar();
                racing.printResult();
            }
        }

        String result = "\n최종 우승자 : ";
        Collections.sort(racings);

        result += racings.get(0).getName();
        int max = racings.get(0).getDistance();
        for (int i = 1; i < racings.size(); i++) {
            Racing r = racings.get(i);
            if (r.getDistance() >= max) {
                result += ", " + r.getName();
            }
        }
        System.out.println(result);
    }
}

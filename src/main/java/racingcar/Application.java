package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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

    }
}

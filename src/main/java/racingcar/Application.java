package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String inputcars = Console.readLine();

        List<String> racingcar = Arrays.asList(inputcars.split(","));

        for (int i = 0; i < racingcar.size(); i++) {
            if (racingcar.get(i).length() > 5) {
                throw new ApplicationException();
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(Console.readLine());

        Racing.createCars(racingcar);

        System.out.println("실행결과");
        for (int i = 0; i < number; i++) {
            Racing.racing();
        }

        System.out.print("최종 우승자 : " + Racing.result());
    }
}

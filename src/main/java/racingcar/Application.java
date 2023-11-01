package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        int number = generator.createRandomNumber();
//        System.out.println(number);

//        boolean moving1 = Referee.checkMoveForward();
//        boolean moving2 = Referee.checkMoveForward();
//        System.out.println(moving1);
//        System.out.println(moving2);
    }

    public static List<String> askCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputArray = input.split(",");

        List<String> Cars = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            Cars.add(inputArray[i]);
        }
        return Cars;
    }
}

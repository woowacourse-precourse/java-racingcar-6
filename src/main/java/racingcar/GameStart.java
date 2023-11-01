package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameStart {
    public static List<String> userInput() {
        List<String> carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();

        String[] car = carInput.split(",");
        for (String i : car) {
            if (i.trim().length() >= 5) {
                throw new IllegalArgumentException();
            }
            String item = i + " : ";
            carList.add(item);
        }
        return carList;
    }

    public static List<String> start(List<String> carList) {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumberInput = Console.readLine();
        int tryNumber = Integer.parseInt(tryNumberInput);

        int index = 0;

        System.out.println();
        System.out.println("실행 결과");
        while (index < tryNumber) {
            List<String> carRound = GoOrStop.carAccelerator(carList);

            for (String i : carRound) {
                System.out.println(i);
            }
            carList = carRound;
            index++;
            System.out.println();
        }
        return carList;
    }
}

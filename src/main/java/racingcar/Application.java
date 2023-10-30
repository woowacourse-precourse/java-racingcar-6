package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        List<String> names = Arrays.asList(nameInput.split(","));

        if (Checker.isNameAllCorrect(names) == false) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = new ArrayList<>();

        for (Integer nameIndex = 0; nameIndex < names.size(); nameIndex++) {
            cars.add(new Car(names.get(nameIndex)));
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        String countInput = Console.readLine();
        Integer count = Integer.parseInt(countInput);

        System.out.println();

        System.out.println("실행 결과");
        for (Integer gameCount = 1; gameCount <= count; gameCount++) {
            Game.forwardOrStop(cars);

            Printer.cars(cars);
        }

        List<String> winners = Checker.judgeWinners(cars);

        Printer.winners(winners);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        String[] names = inputNames.split(",");
        Car[] cars = new Car[names.length];

        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5)
                throw new IllegalArgumentException("");
            cars[i] = new Car(names[i], 0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        NumberGenerator numberGenerator = new NumberGenerator();
        MoveForward moveForward = new MoveForward();
        PrintProcess printProcess = new PrintProcess();
        PickWinners pickWinners = new PickWinners();

        for (int i = 0; i < times; i++) {
            List<Integer> randomNumbers = numberGenerator.createRandomNumbers(cars.length);
            moveForward.moving(cars, randomNumbers);
            printProcess.print(cars);
        }

        String winners = String.join(",", pickWinners.pick(cars));
        System.out.println("최종 우승자 : " + winners);
    }
}

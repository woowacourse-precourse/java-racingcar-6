package racingcar.service;

import racingcar.domain.Cars;

import java.util.Scanner;

public class RacingService {
    private Cars cars;

    public void startRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        String playerInput = sc.nextLine();
        String[] names = playerInput.split(",");
        cars = new Cars(names);

        System.out.println("시도할 회수는 몇회인가요?");
        int trial = sc.nextInt();

        System.out.println("\n실행 결과");
        for (int i = 0; i < trial; i++) {
            cars.race();
        }

        cars.printWinners();
    }

}

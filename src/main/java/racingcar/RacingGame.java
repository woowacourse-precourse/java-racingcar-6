package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private int count;
    private RacingCars racingCars;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        racingCars = new RacingCars();

        for (String carName : carNames) {
            validateCarName(carName);
            racingCars.add(new RacingCar(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        count = Integer.parseInt(input);

        while (count > 0) {
            racingCars.turnOn();
            count--;
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}

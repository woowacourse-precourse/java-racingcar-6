package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RaceSetting {
    public String[] regCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return splitCars(cars);
    }

    public String[] splitCars(String cars) {
        return cars.split(",");
    }

    public int playNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        return StringToNumber(input);
    }

    public int StringToNumber(String input) {
        return Integer.parseInt(input);
    }
}

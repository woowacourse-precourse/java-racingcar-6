package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RaceSetting {
    public String[] regCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return carValidCheck(cars);
    }

    public String[] splitCars(String cars) {
        return cars.split(",");
    }

    public String[] carValidCheck(String cars) {
        String[] carList = splitCars(cars);
        for (String car : carList) {
            if (car.length() > 5) throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
        return carList;
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

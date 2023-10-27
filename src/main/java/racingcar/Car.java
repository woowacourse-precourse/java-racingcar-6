package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

class Car {
    String name;
    int location = 0;

    public void moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number > 3) {
            location++;
        }
    }

    public Car(String name) {
        if (name.length() > 5 || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이거나 5자 이내여야 합니다.");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(location);
    }

    public static List<Car> createCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Arrays.stream(readLine().split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public static StringBuilder moveCar(List<Car> carList, int repeatCount) {
        StringBuilder output = new StringBuilder("실행 결과\n");

        for (int i = 0; i < repeatCount; i++) {
            carList.stream().forEach(car -> {
                car.moveForward();
                output.append(car).append("\n");
            });

            output.append("\n");
        }

        int size = output.length();
        return output.delete(size - 1, size);
    }

}
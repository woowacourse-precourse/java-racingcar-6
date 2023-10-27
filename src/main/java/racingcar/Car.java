package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public static void printFinalWinner(List<Car> carList) {
        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");

        List<String> winner = findWinner(carList);
        winner.stream().forEach(carName -> {
            stringBuilder.append(carName).append(",");
        });

        int size = stringBuilder.length();
        System.out.println(stringBuilder.delete(size - 1, size));
    }

    public static List<String> findWinner(List<Car> carList) {
        int record = 0;
        ArrayList<String> carNames = new ArrayList<>();

        for (Car car : carList) {
            if (record < car.location) {
                record = car.location;
                carNames.clear();

                carNames.add(car.name);
            } else if (record == car.location) {
                carNames.add(car.name);
            }
        }

        return carNames;
    }

}
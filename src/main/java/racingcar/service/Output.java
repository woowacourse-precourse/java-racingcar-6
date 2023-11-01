package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public void printCarStatus(Car car, int index) {
        String carName = car.carName.get(index);
        int carDistance = car.carDistance[index];

        System.out.println(String.format("%s : %d", carName, carDistance));
    }

    public void printWinner(Car car) {
        int maxCarDistance = Arrays.stream(car.carDistance).max().getAsInt();
        List<String> winner = new ArrayList<>();

        System.out.print("최종 우승자 : ");

        for (String carName : car.carName) {
            int carNameIndex = car.carName.indexOf(carName);

            if (maxCarDistance == carNameIndex) {
                winner.add(carName);
            }
        }

        String result = winner.stream().collect(Collectors.joining(", "));
        System.out.print(result);
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars;
    private Judge judge;

    public void racingRun(String[] inputs, int repeatCount) {

        createCars(inputs);
        racingRepeatRun(repeatCount);
    }

    private void createCars(String[] inputs) {

        cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {

            cars.add(new Car(inputs[i]));
        }
    }

    private void racingRepeatRun(int repeatCount) {

        System.out.println("실행 결과");

        for (int i = 0; i < repeatCount; i++) {

            for (int j = 0; j < cars.size(); j++) {

                cars.get(j).go();
            }

            System.out.println();
        }

        checkResult(this.cars);
    }

    private void checkResult(List<Car> cars) {

        this.judge = new Judge();
        judge.judgeFinalResult(cars);
    }
}

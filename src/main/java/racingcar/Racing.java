package racingcar;

import java.util.List;

public class Racing {

    private List<Car> cars;
    private Judge judge;

    public void racingRun(String[] inputs, int repeatCount) {

        createCars(inputs);
        racingRepeatRun(repeatCount);
    }

    private void createCars(String[] inputs) {

        for(int i = 0; i < inputs.length; i++) {

            cars.add(new Car(inputs[i]));
        }
    }

    private void racingRepeatRun(int repeatCount) {

        for(int i = 0; i < repeatCount; i++) {

            for(int j = 0; j < cars.size(); j++) {

                cars.get(j).go();
            }
        }
    }

    private List<Car> checkResult() {

        judge = new Judge();
        return judge.judgeResult();
    }
}

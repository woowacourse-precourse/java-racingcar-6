package racingcar;

import static racingcar.Application.cars;

public class RacingSetting {
    public static void createCars(String carNames) {
        InputException.isContainComma(carNames);
        createCar(carNames);
        Integer carsLength = cars.size();
    }

    private static void createCar(String carNames) {
        for (String carName : carNames.split(",")) {
            InputException.isCorrectNameLength(carName.trim());
            Car car = new Car(carName.trim(), 0);
            cars.add(car);
        }
    }


    public static Integer saveTrialNumber(String trialNumberInput) {
        return InputException.isNumberFormat(trialNumberInput);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static List<Car> cars = new ArrayList<>();
    static ArrayList<String> winners = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCars(Console.readLine().trim());
        System.out.println("시도할 회수는 몇회인가요?");
        Integer trialNumber = saveTrialNumber(Console.readLine().trim());
        System.out.println("\n실행결과");
        DriveProcedure.drive(trialNumber);
        RacingResult.showWinner();
    }
    private static void createCars(String carNames) {
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


    private static Integer saveTrialNumber(String trialNumberInput) {
        return InputException.isNumberFormat(trialNumberInput);
    }

}
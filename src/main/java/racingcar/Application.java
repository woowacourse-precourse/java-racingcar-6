package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarGroup carGroup = new CarGroup();
        inputCars(carGroup);
    }

    private static void inputCars(CarGroup carGroup) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = readLine();
        for (String carName : cars.split(",")) {
            Car car = new Car(carName);
            carGroup.addCar(car);
        }
    }
}

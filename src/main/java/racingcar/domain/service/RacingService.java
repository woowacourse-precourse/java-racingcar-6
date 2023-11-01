package racingcar.domain.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.util.generator.RandomNumberGenerator;
import racingcar.domain.util.validator.CarNameValidator;
import racingcar.domain.view.inputer.CarInputer;
import racingcar.domain.view.printer.IntermediateCoursePrinter;
import racingcar.domain.util.referee.InGameReferee;

public class RacingService {
    public void getResult(List<Car> carList) {
        List<Integer> randomList = RandomNumberGenerator.createListNumber(carList.size());
        runRacing(carList, randomList);
        IntermediateCoursePrinter.printResult(carList);
    }

    public List<Car> getCars() {
        List<String> names = CarInputer.getName();
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        CarNameValidator.checkDuplication(cars);
        return cars;
    }

    /**
     * 생성된 무작위 값이 LOWER_LIMIT 이상이면 전진
     *
     * @param carList    입력받은 자동차들
     * @param randomList 생성된 랜덤 숫자들
     */
    private void runRacing(List<Car> carList, List<Integer> randomList) {
        for (int index = 0; index < carList.size(); index++) {
            if (InGameReferee.isBiggerLowerLimit(randomList.get(index))) {
                Car car = carList.get(index);
                car.forward();
            }
        }
    }
}

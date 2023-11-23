package racingcar.domain.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.valueobject.Challenge;
import racingcar.domain.util.generator.RandomNumberGenerator;
import racingcar.domain.util.validator.CarNameValidator;
import racingcar.domain.view.inputer.CarInputer;
import racingcar.domain.view.printer.IntermediateCoursePrinter;
import racingcar.domain.util.referee.InGameReferee;

public class RacingService {
    private void getResult(List<Car> cars) {
        List<Integer> randoms = RandomNumberGenerator.createListNumber(cars.size());
        runRacing(cars, randoms);
        IntermediateCoursePrinter.printResult(cars);
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
     * @param cars    입력받은 자동차들
     * @param randoms 생성된 랜덤 숫자들
     */
    private void runRacing(List<Car> cars, List<Integer> randoms) {
        for (int index = 0; index < cars
                .size(); index++) {
            if (InGameReferee.isBiggerLowerLimit(randoms.get(index))) {
                Car car = cars
                        .get(index);
                car.forward();
            }
        }
    }

    /*
    몇번의 레이스를 하는지에 따른 결과
     */
    public void challengeRace(List<Car> cars, Challenge challenge) {
        for (int i = 0; i < challenge.getNumber(); i++) {
            getResult(cars);
        }
    }
}

package racingcar.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.exception.CarRepositoryException;
import racingcar.exception.validtaion.CarValidationHandler;

class CarServiceTest {

    CarRepository carRepository = new CarRepository();
    RacingCarGameRepository racingCarGameRepository = new RacingCarGameRepository();
    CarService carService = new CarService(carRepository);

    @BeforeEach
    void setUp() {
        carRepository.clearAll();
        racingCarGameRepository.clearAll();
    }

    @AfterEach
    void tearDown() {
        carRepository.clearAll();
        racingCarGameRepository.clearAll();
    }

    @Test
    @DisplayName("자동차 이름을 검증하고 이상이 없으면 저장한다.")
    void saveCarName() {
        // given
        String carNames = "pobi,ja1va,1";

        // when
        carService.registerCarsByCarNames(carNames);

        // then
        List<Car> cars = carRepository.findAll();
        assertThat(cars).hasSize(3)
                .extracting("carName", "distance")
                .contains(
                        tuple("pobi", 0),
                        tuple("ja1va", 0),
                        tuple("1", 0)
                );
    }

    @Test
    @DisplayName("자동차 이름에 이상이 있으면 예외가 발생한다.(5글자 이하가 아닌 경우)")
    void saveCarNameLengthException() {
        // given
        String carNames = "pobi,woni,jun433";

        // when // then
        assertThatThrownBy(() -> carService.registerCarsByCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_LENGTH_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름에 이상이 있으면 예외가 발생한다.(글자 포맷이 다른 경우)")
    void saveCarNameFormatException() {
        // given
        String carNames = "pobi,woni,세웅";

        // when // then
        assertThatThrownBy(() -> carService.registerCarsByCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름에 이상이 있으면 예외가 발생한다.(중복이 있는 경우)")
    void saveCarNameDuplicatedException() {
        // given
        String carNames = "pobi,woni,pobi";

        // when // then
        assertThatThrownBy(() -> carService.registerCarsByCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_DUPLICATED_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름에 이상이 있으면 예외가 발생한다.(1개 이하인 경우)")
    void saveCarNameOneException() {
        // given
        String carNames = "pobi";

        // when // then
        assertThatThrownBy(() -> carService.registerCarsByCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.MIN_CAR_NAMES_REQUIRED_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름에 이상이 있으면 예외가 발생한다.(입력하지 않은 자동차 이름이 있는 경우)")
    void saveCarNameExceptionHasText() {
        // given
        String carNames = "pobi,  ,won";

        // when // then
        assertThatThrownBy(() -> carService.registerCarsByCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.PROMPT_CAR_NAME_INPUT_RESTRICTION);
    }

    @Test
    @DisplayName("4이상의 숫자를 입력 받으면 자동차는 1칸 전진한다.")
    void moveForward() {
        // given
        String carName = "pobi";
        carRepository.save(Car.create(carName));
        int forwardNumber = 4;

        // when
        carService.move(carName, forwardNumber);

        // then
        Car car = carRepository.findByCarName(carName).get();
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getCarName()).isEqualTo(carName),
                () -> assertThat(car.getDistance()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("4미만의 숫자를 입력 받으면 자동차는 정지한다.")
    void moveStop() {
        // given
        String carName = "pobi";
        carRepository.save(Car.create(carName));
        int stopNumber = 0;

        // when
        carService.move(carName, stopNumber);

        // then
        Car car = carRepository.findByCarName(carName).get();
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getCarName()).isEqualTo(carName),
                () -> assertThat(car.getDistance()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("자동차 이름에 맞는 자동차가 없으면 예외가 발생한다.")
    void moveException() {
        // given
        String carName = "pobi";
        int stopNumber = 0;

        // when // then
        assertThatThrownBy(() -> carService.move(carName, stopNumber))
                .isInstanceOf(CarRepositoryException.class)
                .hasMessage(CarRepositoryException.NOT_FOUND);
    }
}
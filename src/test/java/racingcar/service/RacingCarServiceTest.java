package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.WinnerDto;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TryNumberValidator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private Cars cars;
    private CarNameValidator carNameValidator;
    private TryNumberValidator tryNumberValidator;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        racingCarService = new RacingCarService(cars);
        carNameValidator = new CarNameValidator();
        tryNumberValidator = new TryNumberValidator();
    }

    @Test
    public void 시도_회수_입력_검증_성공() {
        String validInput = "5";

        Assertions.assertDoesNotThrow(() -> racingCarService.inputValidate(validInput,tryNumberValidator));
    }

    @Test
    public void 자동차_이름_입력_검증_성공() {
        String validInput = "김명준";

        Assertions.assertDoesNotThrow(() -> racingCarService.inputValidate(validInput,carNameValidator));
    }

    @Test
    public void 자동차_이름_입력() {
        String carNames = "car1,car2,car3";
        racingCarService.insertCarNames(carNames);

        List<Car> carList = cars.getCars();

        assertEquals(3, carList.size());
    }

    @Test
    public void 시도_회수_입력() {
        racingCarService.insertTryNumber("5");
        int tryNumber = racingCarService.getTryNumber();

        assertEquals(5, tryNumber);
    }

    @Test
    public void 레이싱_오버() {
        racingCarService.insertTryNumber("3");
        assertFalse(racingCarService.isRaceOver());

        racingCarService.insertTryNumber("0");
        assertTrue(racingCarService.isRaceOver());
    }

    @Test
    public void 우승자_반환() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        cars.insertCarsNames(carNames);
        Car car1 = cars.getCars().get(0);
        Car car2 = cars.getCars().get(1);
        Car car3 = cars.getCars().get(2);
        car1.goToPoint(5);
        car2.goToPoint(7);
        car3.goToPoint(7);

        List<WinnerDto> result = racingCarService.getWinner();

        assertEquals(2, result.size());
    }
}


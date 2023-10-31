package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final int MIN_NUMBER = 0;
    private static final int STANDARD = 4;
    private static final int MAX_NUMBER = 9;

    @Test
    void 기름이_충분하지_않을_경우_이동하지_않음() {
        // Gvien
        Car car = Car.from("car");
        int insufficientGasoline = getInsufficientGasoline();
        int expectedDistance = 0;

        // When
        car.tryDrive(insufficientGasoline);

        // Then
        assertTrue(car.matchesDrivenDistance(expectedDistance));
    }

    @Test
    void 기름이_충분할_경우_이동() {
        // Gvien
        Car car = Car.from("car");
        int insufficientGasoline = getSufficientGasoline();
        int expectedDistance = 1;

        // When
        car.tryDrive(insufficientGasoline);

        // Then
        assertTrue(car.matchesDrivenDistance(expectedDistance));
    }

    @Test
    void nameAndDistanceMessage_올바르게_생성() {
        // Given
        Car car = Car.from("test");
        car.tryDrive(STANDARD);
        String expectedResult = "test : -\n";

        // When
        String actualResult = car.generateNameAndDistanceMessage();

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 가장_먼_이동거리_올바르게_조회() {
        // Given
        List<Car> cars = List.of(Car.from("car1"), Car.from("car2"), Car.from("car3"));
        Car carWithMaxDistance = cars.get(getRandomNumberInRange(0, cars.size() - 1));
        int expectedResult = getRandomNumberInRange(1, 10);
        for (int i = 0; i < expectedResult; i++) {
            carWithMaxDistance.tryDrive(STANDARD);
        }

        // When
        int actualResult = Car.getMaxDistanceAmongCars(cars);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    private int getSufficientGasoline() {
        return getRandomNumberInRange(STANDARD, MAX_NUMBER);
    }

    private int getInsufficientGasoline() {
        return getRandomNumberInRange(MIN_NUMBER, STANDARD - 1);
    }

    private int getRandomNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
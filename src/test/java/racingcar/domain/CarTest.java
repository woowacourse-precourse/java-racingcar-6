package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CarTest {

    @DisplayName("이름이 5글자 이하인 Car만 생성가능하다")
    @ParameterizedTest
    @CsvSource(value = {"'',true", "a,true", "ab,true", "abc,true", "abcd,true", "abcde,true", "abcdef,false"})
    void forNameTest(String carName, boolean canCreate) {
        if (canCreate) {
            assertInstanceOf(Car.class, Car.forName(carName));
        } else {
            assertThrows(IllegalArgumentException.class,
                    () -> Car.forName(carName),
                    "Car 이름은 5자 이하여야 합니다.");
        }
    }


}

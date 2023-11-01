package racingcar.developtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarFactory;

public class CarFactoryTest {

    @Test
    void hasDuplicatedName_중복된_이름_가지고_있을때_예외() {
        InputStream readLine = setReadLine("pobi,pobi");
        System.setIn(readLine);
        CarFactory carFactory = new CarFactory();
        assertThatThrownBy(carFactory::createCars)
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}

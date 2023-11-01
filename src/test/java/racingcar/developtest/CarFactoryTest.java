package racingcar.developtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;

public class CarFactoryTest {

    @Test
    void createCar_쉼표기준_자동차_객체_리스트_생성() {
        InputStream readLine = setReadLine("pobi,woni");
        System.setIn(readLine);
        CarFactory carFactory = new CarFactory();
        assertDoesNotThrow(carFactory::createCars);
    }

    @Test
    void creatCar_쉼표없이_자동차_하나일_때_리스트_생성() {
        InputStream readLine = setReadLine("pobi");
        System.setIn(readLine);
        CarFactory carFactory = new CarFactory();
        assertDoesNotThrow(carFactory::createCars);
    }

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

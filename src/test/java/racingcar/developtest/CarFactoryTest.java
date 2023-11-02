package racingcar.developtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;

public class CarFactoryTest {


    @Test
    void createCars_두개_이상_자동차_객체_생성(){
        InputStream readLine = setReadLine("pobi,crong");
        System.setIn(readLine);
        CarFactory carFactory = new CarFactory();
        assertDoesNotThrow(carFactory::createCars);
        Console.close();
    }
    @Test
    void createCars_한개_일때_자동차_객체_생성(){
        InputStream readLine = setReadLine("pobi");
        System.setIn(readLine);
        CarFactory carFactory = new CarFactory();
        assertDoesNotThrow(carFactory::createCars);
        Console.close();
    }
    @Test
    void hasDuplicatedName_중복된_이름_가지고_있을때_예외() {
        InputStream readLine = setReadLine("pobi,pobi");
        System.setIn(readLine);
        CarFactory carFactory = new CarFactory();
        assertThatThrownBy(carFactory::createCars)
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}

package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    
    @Test
    void 자동차들이_5자_이내인지(){
        List<Car> carList = Arrays.asList(new Car("poni"), new Car("woni"), new Car("jun"));

        InputValidator.validate(carList);
    }
}
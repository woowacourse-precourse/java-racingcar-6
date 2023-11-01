package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validation.ParticipatingCarsValidation;

public class ParticipatingCarsValidationTest {

    @Test
    public void testValidate_Participating_CarsEmpty() {
        ParticipatingCarsValidation validation = new ParticipatingCarsValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validation.validateParticipatingCars(Collections.emptyList());
        });

        Assertions.assertEquals("경주에 참가하는 차량이 없습니다.", exception.getMessage());
    }

    @Test
    public void testValidate_Participating_CarsValid() {
        ParticipatingCarsValidation validation = new ParticipatingCarsValidation();

        List<String> validCars = new ArrayList<>();
        validCars.add("pobi");
        validCars.add("jun");
        validation.validateParticipatingCars(validCars);
    }
}



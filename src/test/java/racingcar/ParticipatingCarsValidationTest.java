package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.ParticipatingCarsValidation;

public class ParticipatingCarsValidationTest {

    @DisplayName("참가 차량 검증 - 차량이 비어있는 경우")
    @Test
    public void testValidateParticipatingCarsEmpty() {
        ParticipatingCarsValidation validation = new ParticipatingCarsValidation();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validation.validateParticipatingCars(Collections.emptyList());
        });

        assertEquals("경주에 참가하는 차량이 없습니다.", exception.getMessage());
    }

    @DisplayName("참가 차량 검증 - 유효한 경우")
    @Test
    public void testValidateParticipatingCarsValid() {
        ParticipatingCarsValidation validation = new ParticipatingCarsValidation();

        List<String> validCars = new ArrayList<>();
        validCars.add("pobi");
        validCars.add("jun");
        validation.validateParticipatingCars(validCars);
    }
}



package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.service.ValidationService;

public class CarTest {
    ValidationService validationService = new ValidationService();

    @Test
    void checkCarNameLength() {
        String carName = "pobitest";

        assertThrows(IllegalArgumentException.class, () -> {
            validationService.checkCarNames(carName);
        });
    }

    @Test
    void checkCarNameSeperate() {
        String carName = "pobi.jane";

        assertThrows(IllegalArgumentException.class, () -> {
            validationService.checkCarNames(carName);
        });
    }

    @Test
    void checkCarNameEmpty() {
        String carName = "";

        assertThrows(IllegalArgumentException.class, () -> {
            validationService.checkCarNames(carName);
        });
    }

    @Test
    public void checkGenerateRandomNumber() {
        boolean isRandomNumberGeneratedProperly = true;

        for (int i = 0; i < 100; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber < 0 || randomNumber > 9) {
                isRandomNumberGeneratedProperly = false;
                break;
            }
        }
        assertTrue(isRandomNumberGeneratedProperly);
    }
}

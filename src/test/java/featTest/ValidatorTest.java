package featTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.RacingCar;


public class ValidatorTest {
    List<RacingCar> racingCarsList = new ArrayList<>();
    String[] carNames;

    @BeforeEach
    void setUpCarNameCountData() {
        User1 user1 = new User1();
        carNames = user1.inputCarNames();
    }
    @BeforeEach
    void setUpCarNameLengthData() {
        User2 user2 = new User2();
        carNames = user2.inputCarNames();
    }

    @Test
    void checkCarNameCountTest() {
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> validator.checkCarNameCount(carNames));
    }

    @Test
    void checkCarNameLengthTest() {
        Validator validator = new Validator();

        assertThrows(IllegalArgumentException.class, () -> validator.checkCarNameLength(carNames));
    }

    class User1 {
        public String[] inputCarNames() {
            return new String[]{"A"};
        }
    }
    class User2 {
        public String[] inputCarNames() {
            return new String[]{"Aasdasd"};
        }
    }

    class Validator {
        void checkCarNameCount(String[] carNames) {
            if (carNames.length <= 1) {
                throw new IllegalArgumentException("??? ? ?? ?? ???? 2? ?? ???.");
            }
        }

        void checkCarNameLength(String[] carNames) {
            for (String carName : carNames) {
                carNameMaxLength(carName);
            }
        }

        void carNameMaxLength(String carName) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException("??? ??? ?? ??? 5?? ?? ???.");
            }
        }
    }
}

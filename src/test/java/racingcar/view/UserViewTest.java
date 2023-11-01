package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserViewTest {
    private UserView userView;

    @BeforeEach
    public void setUp() {
        userView = new UserView();
    }

    @Test
    public void testValidateNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            userView.validateNullValue("");
        });
    }

    @Test
    public void testValidCoinValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            userView.validCoinValue(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            userView.validCoinValue(-1);
        });
    }
}

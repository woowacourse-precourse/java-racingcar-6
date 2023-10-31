/*package controller;

import model.CarList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.UserView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserControllerTest {
    private UserView userController;
    private CarList carList;

    @BeforeEach
    void setUp() {
        userController = new UserView(carList);
        carList = new CarList();
    }

    @Test
    void testInputUserValue() {
        userController.registerCar("Car1,Car2,Car3");

        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getName()).isEqualTo("Car1");
        assertThat(carList.get(1).getName()).isEqualTo("Car2");
        assertThat(carList.get(2).getName()).isEqualTo("Car3");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> userController.registerCar("InvalidCarName"));
    }

    @Test
    void testInputCarToList() {
        userController.inputCarToList("Car1");

        assertThat(carList.size()).isEqualTo(1);
        assertThat(carList.get(0).getName()).isEqualTo("Car1");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> userController.inputCarToList("InvalidCarName"));
    }

    @Test
    void testValidateNameLength() {
        userController.validateNameLength("Car1");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> userController.validateNameLength("InvalidCarName"));
    }

    @Test
    void testRegisterCoin() {
        userController.registerCoin("11");

        assertThat(userController.getCoin()).isEqualTo(11);
    }
}*/

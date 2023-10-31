package controller;

import model.Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserControllerTest {
    private UserController userController;
    private ArrayList<Car> racingCars;

    @BeforeEach
    void setUp() {
        userController = new UserController();
        racingCars = userController.getRacingCars();
    }

    @Test
    void testInputUserValue() {
        userController.registerCar("Car1,Car2,Car3");
        ArrayList<Car> racingCars = userController.getRacingCars();

        assertThat(racingCars).hasSize(3);
        assertThat(racingCars.get(0).getName()).isEqualTo("Car1");
        assertThat(racingCars.get(1).getName()).isEqualTo("Car2");
        assertThat(racingCars.get(2).getName()).isEqualTo("Car3");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> userController.registerCar("InvalidCarName"));
    }

    @Test
    void testInputCarToList() {
        userController.inputCarToList("Car1");

        assertThat(racingCars).hasSize(1);
        assertThat(racingCars.get(0).getName()).isEqualTo("Car1");

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
}

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("jun");
    }

    @Test
    void 한칸이동() {
        int currentPosition = car.getPosition();
        car.moveForward();
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(currentPosition + 1);
    }

    @Test
    void 두칸이동() {
        int currentPosition = car.getPosition();
        car.moveForward();
        car.moveForward();
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(currentPosition + 2);
    }

    @Test
    void 세칸이동() {
        int currentPosition = car.getPosition();
        car.moveForward();
        car.moveForward();
        car.moveForward();
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isEqualTo(currentPosition + 3);
    }
}
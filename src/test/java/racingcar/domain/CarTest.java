package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void driveTest_whenNumber0(){
        // Given
        int randomNumber = 0;
        Driver driver = new TestDriver(randomNumber);
        Car car = new Car("test", driver);

        // When
        car.drive();

        //Then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    void driveTest_whenNumber3(){
        // Given
        int randomNumber = 3;
        Driver driver = new TestDriver(randomNumber);
        Car car = new Car("test", driver);

        // When
        car.drive();

        //Then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    void driveTest_whenNumber4(){
        // Given
        int randomNumber = 4;
        Driver driver = new TestDriver(randomNumber);
        Car car = new Car("test", driver);

        // When
        car.drive();

        //Then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void driveTest_whenNumber5(){
        // Given
        int randomNumber = 5;
        Driver driver = new TestDriver(randomNumber);
        Car car = new Car("test", driver);

        // When
        car.drive();

        //Then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void driveTest_whenNumber9(){
        // Given
        int randomNumber = 9;
        Driver driver = new TestDriver(randomNumber);
        Car car = new Car("test", driver);

        // When
        car.drive();

        //Then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}

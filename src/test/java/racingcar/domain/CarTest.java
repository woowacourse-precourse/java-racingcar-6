package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    final int STAY = 3;
    final int MOVE = 5;
    @Test
    void 멈춤() {
        Car car = new Car(new CarName("pobi")){
            @Override
            protected int getRandomNumber(){
                return STAY;
            }
        };

        car.move();

        assertEquals(new Location(0), car.getLocation());
    }

    @Test
    void 이동() {
        Car car = new Car(new CarName("pobi")){
            @Override
            protected int getRandomNumber(){
                return MOVE;
            }
        };

        car.move();

        assertEquals(new Location(1), car.getLocation());
    }

    @Test
    void 우승자인지_확인() {
        Car car = new Car(new CarName("pobi")){
            @Override
            protected int getRandomNumber(){
                return MOVE;
            }
        };

        car.move();
        car.move();

        assertTrue(car.isWinner(new Location(1)));
    }
}
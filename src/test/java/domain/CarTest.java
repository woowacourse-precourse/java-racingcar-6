package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movable;
import racingcar.domain.car.Car;

public class CarTest {
    private Car car;

    @BeforeEach
    public void Init() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("자동차 생성자 생성 검증")
    public void 자동차_생성자_테스트() throws Exception {
        assertEquals("pobi", car.getName());
        ;
        assertEquals(0, car.getDistance());
    }

    @Test
    @DisplayName("자동차의 전진과 후진이 되는지 검증")
    public void 자동차_전진_후진_테스트() throws Exception {
        /*
        전진
         */
        car.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        assertEquals(1, car.getDistance());

        /*
        정지
         */
        car.goForward(new Movable() {
            public boolean canMove() {
                return false;
            }
        });
        assertEquals(1, car.getDistance());
    }

    @Test
    @DisplayName("자동차 거리에 따른 출력이 되는지 검증")
    public void 자동차_거리_출력_테스트() throws Exception {
        /*
        한 번 갈때
         */
        car.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        assertEquals("-", car.getCarDistanceChar());

        /*
        두 번 더 갈 때
         */
        car.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        car.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        //then
        assertEquals("---", car.getCarDistanceChar());
    }
}

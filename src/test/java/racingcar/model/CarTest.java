package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void Car_객체_생성_테스트() {
        try {
            Car car = new Car(new Name("픽업 트럭"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void Car_객체_생성_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(null);
        });
    }

    @Test
    void getMyName_테스트() {
        Car c1 = new Car(new Name("픽업 트럭"));
        Car c2 = new Car(new Name("스포츠 카"));
        Car c3 = new Car(new Name("자전거"));

        assertEquals(c1.getMyName(), "픽업 트럭");
        assertEquals(c2.getMyName(), "스포츠 카");
        assertEquals(c3.getMyName(), "자전거");
    }

    @Test
    void isNamesake_테스트() {
        Car c1 = new Car(new Name("a"));
        Car c2 = new Car(new Name("a"));
        Car c3 = new Car(new Name("b"));

        assertTrue(c1.isNamesake(c1));
        assertTrue(c1.isNamesake(c2));
        assertFalse(c2.isNamesake(c3));
        assertFalse(c3.isNamesake(c2));
    }

    /**
     * drive_메소드_전진_확률_테스트 에서 사용
     * @return
     */
    int countFowardDuringDrive1000000000Times() {
        Car car = new Car(new Name("test"));
        final int rep = 1_000_000_000;

        int cnt = 0;
        for (int i = 0; i < rep; i++) {
            if (car.drive()) {
                cnt++;
            }
        }

        return cnt;
    }
    @Test
    void drive_메소드_전진_확률_테스트() {

        int cnt;
        for (int i = 0; i < 10; i++) {
            System.out.print("#" + (i+1));
            cnt = countFowardDuringDrive1000000000Times();
            System.out.println(" -> " + cnt);
            if (cnt < 590_000_000 || 610_000_000 < cnt) {
                fail();
            }
        }

    }

    /**
     * toString_테스트에서 활용하기 위한 메소드입니다.
     * 주어진 car를 n번 전진시킵니다.
     * @param car
     * @param n
     */
    void proceedNTimes(Car car, int n) {
        int cnt = 0;
        while (cnt < n) {
            if (car.drive()) {
                cnt++;
            }
        }
    }
    @Test
    void toString_테스트() {
        Car car = new Car(new Name("픽업 트럭"));
        proceedNTimes(car, 3);

        assertEquals(car.toString(), "픽업 트럭 : ---");
    }
}
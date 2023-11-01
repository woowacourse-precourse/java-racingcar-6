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

    @Test
    void isNotLoseTo_테스트() {
        Car c1 = new Car(new Name("a"));
        Car c2 = new Car(new Name("b"));
        Car c3 = new Car(new Name("c"));

        proceedNTimes(c1, 0);
        proceedNTimes(c2, 1);
        proceedNTimes(c3, 1);

        assertTrue(c2.isNotLoseTo(c1));
        assertTrue(c2.isNotLoseTo(c3));
        assertTrue(c3.isNotLoseTo(c2));
    }

    @Test
    void compareTo_테스트() {
        Car c1 = new Car(new Name("a"));
        Car c2 = new Car(new Name("b"));
        Car c3 = new Car(new Name("c"));
        Car c4 = new Car(new Name("d"));

        proceedNTimes(c1, 0);
        proceedNTimes(c2, 1);
        proceedNTimes(c3, 1);
        proceedNTimes(c4, 2);

        // 자기 자신과 비교
        assertEquals(0, c1.compareTo(c1));

        // 다른 객체와 동일성 비교
        assertEquals(0, c2.compareTo(c3));

        // 대칭성
        assertEquals(c1.compareTo(c2), c2.compareTo(c1) * (-1));

        // 추이성
        if (
                (c4.compareTo((c3)) > 0)
                        && (c3.compareTo(c2) == 0)
                        && c2.compareTo(c1) > 0
        ) {
            assertTrue(c4.compareTo(c2) > 0);
            assertTrue(c4.compareTo(c1) > 0);
        }

        // 반사성
        if (c2.compareTo(c3) == 0) {
            assertTrue((c2.compareTo(c1) * c3.compareTo(c1)) > 0);
        }
    }
}
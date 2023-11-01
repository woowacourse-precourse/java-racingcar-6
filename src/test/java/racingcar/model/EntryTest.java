package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EntryTest {

    @Test
    void join_테스트() {
        try {
            Car c1 = new Car(new Name("a"));
            Car c2 = new Car(new Name("bc"));
            Car c3 = new Car(new Name("d e f"));

            Entry entry = new Entry();
            entry.join(c1);
            entry.join(c2);
            entry.join(c3);

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    void 중복_join_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car c1 = new Car(new Name("abc"));
            Car c2 = new Car(new Name("abc"));

            Entry entry = new Entry();
            entry.join(c1);
            entry.join(c2);
        });
    }

    @Test
    void size_테스트() {
        Car c1 = new Car(new Name("a"));
        Car c2 = new Car(new Name("b"));
        Car c3 = new Car(new Name("c"));

        Entry entry = new Entry();
        entry.join(c1);
        entry.join(c2);
        entry.join(c3);

        assertEquals(3, entry.size());
    }

    /**
     * getWinners_테스트에서 활용하기 위한 메소드입니다.
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
    void getWinners_테스트() {
        Car c1 = new Car(new Name("a"));
        proceedNTimes(c1, 1);

        Car c2 = new Car(new Name("b"));
        proceedNTimes(c2, 2);

        Car c3 = new Car(new Name("c"));
        proceedNTimes(c3, 2);

        Entry entry = new Entry();
        entry.join(c1);
        entry.join(c2);
        entry.join(c3);

        List<Car> compare = new ArrayList<>();
        compare.add(c2);
        compare.add(c3);

        assertEquals(compare, entry.getWinners());
    }
}
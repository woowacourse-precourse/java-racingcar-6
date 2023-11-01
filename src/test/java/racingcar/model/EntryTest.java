package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

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
}
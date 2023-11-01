package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DistanceTest {
    @Test
    void 매개변수_없는_생성자를_통한_객체_생성() {
        try {
            Distance d = new Distance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void 정수_하나를_요구하는_생성자를_통한_객체_생성() {
        try {
            Distance d = new Distance(10);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void 음수를_전달하여_객체를_생성하면_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Distance d = new Distance(-1);
        });
    }

//    // 너무 큰 정수를 전달하면 컴파일 에러가 발생함을 확인
//    @Test
//    void 너무_큰_정수를_전달하여_객체를_생성하면_실패() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Long tooBig = new Long(Integer.MAX_VALUE + 1);
//            Distance d = new Distance(tooBig);
//        });
//    }

    @Test
    void 최대의_Distance_최소의_Distance_객체에대해_increaseByOne_메소드_적용() {
        Distance d1 = new Distance(0);
        Distance d2 = new Distance(Integer.MAX_VALUE);

        assertTrue(d1.increaseByOne());
        assertFalse(d2.increaseByOne());
    }

    @Test
    void Distance_compareTo_테스트() {
        Distance d1 = new Distance(0);
        Distance d2 = new Distance(1);
        Distance d3 = new Distance(1);
        Distance d4 = new Distance(2);

        // 자기 자신과 비교
        assertEquals(0, d1.compareTo(d1));

        // 다른 객체와 동일성 비교
        assertEquals(0, d2.compareTo(d3));

        // 대칭성
        assertEquals(d1.compareTo(d2), d2.compareTo(d1) * (-1));

        // 추이성
        if (
                (d4.compareTo((d3)) > 0)
                && (d3.compareTo(d2) == 0)
                && d2.compareTo(d1) > 0
        ) {
            assertTrue(d4.compareTo(d2) > 0);
            assertTrue(d4.compareTo(d1) > 0);
        }

        // 반사성
        if (d2.compareTo(d3) == 0) {
            assertTrue((d2.compareTo(d1) * d3.compareTo(d1)) > 0);
        }
    }

    @Test
    void toString_문자열_형식_검사(){
        Distance d1 = new Distance(0);
        Distance d2 = new Distance(1);
        Distance d3 = new Distance(2);
        Distance d4 = new Distance(3);

        assertEquals(d1.toString(), "");
        assertEquals(d2.toString(), "-");
        assertEquals(d3.toString(), "--");
        assertEquals(d4.toString(), "---");
    }
}
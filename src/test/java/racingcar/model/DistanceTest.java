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
    void increaseByOne_메소드_경계값
}
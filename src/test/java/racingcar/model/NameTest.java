package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 유효한_이름으로_Name_객체_생성() {
        try {
            Name n1 = new Name("!");
            Name n2 = new Name("Van");
            Name n3 = new Name("픽업 트럭");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void 유효하지_않은_문자열로_Name_객체_생성하면_실패() {
        // 널
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name(null);
        });

        // 빈 문자열
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name("");
        });
        
        // 앞 또는 뒤에 공백 문자 포함
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name("\t");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name("\n");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name("\r");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name(" a");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name("a ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name(" a a ");
        });
        
        // 5글자 초과
        assertThrows(IllegalArgumentException.class, () -> {
            Name n1 = new Name("123456");
        });
    }

    @Test
    void Name_equals_테스트() {
        Name n1 = new Name("a");
        Name n2 = new Name("a");
        Name n3 = new Name("b");
        Name n4 = new Name("b");

        // 반사성
        assertTrue(n1.equals(n1));

        // 대칭성
        if (n1.equals(n2)) {
            assertTrue(n2.equals(n1));
        }

        // 추이성
        if (n1.equals(n2) && n2.equals(n3)) {
            assertTrue(n1.equals(n3));
        }

        // 널
        assertNotEquals(null, n1);
    }

    @Test
    void toString_형식_테스트() {
        Name n1 = new Name("픽업 트럭");
        Name n2 = new Name("스포츠 카");
        Name n3 = new Name("자전거");

        assertEquals(n1.toString(), "픽업 트럭");
        assertEquals(n2.toString(), "스포츠 카");
        assertEquals(n3.toString(), "자전거");
    }
}
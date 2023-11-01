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
}
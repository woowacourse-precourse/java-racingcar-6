package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RulesTest  extends NsTest {

    @Test
    public void testNameLengthErr() {
        try {
            Rules.nameLengthErr();
        } catch (IllegalArgumentException e) {
            assertEquals("이름을 5자 이하로 작성하세요", e.getMessage());
        }
    }

    @Test
    public void testNameOverlapErr() {
        try {
            Rules.nameOverlapErr();
        } catch (IllegalArgumentException e) {
            assertEquals("자동차명은 중복될 수 없습니다.", e.getMessage());
        }
    }

    @Test
    public void testNameNotInputErr() {
        try {
            Rules.nameNotInputErr();
        } catch (IllegalArgumentException e) {
            assertEquals("입력된 자동차명이 없습니다.", e.getMessage());
        }
    }

    @Test
    public void testNameIsEmpty() {
        try {
            Rules.nameIsEmpty();
        } catch (IllegalArgumentException e) {
            assertEquals("자동차명이 공백일 수 없습니다.", e.getMessage());
        }
    }

    @Test
    public void testNotNumberErr() {
        try {
            Rules.NotNumberErr();
        } catch (IllegalArgumentException e) {
            assertEquals("정수를 입력해야 합니다.", e.getMessage());
        }
    }

    @Test
    public void testNotNaturalNumberErr() {
        try {
            Rules.NotNaturalNumberErr();
        } catch (IllegalArgumentException e) {
            assertEquals("자연수를 입력해야 합니다.", e.getMessage());
        }
    }

    @Test
    public void testNumberNotInputErr() {
        try {
            Rules.numberNotInputErr();
        } catch (IllegalArgumentException e) {
            assertEquals("입력된 수가 없습니다.", e.getMessage());
        }
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

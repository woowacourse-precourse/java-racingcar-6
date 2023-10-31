package racingcar;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RacingCarValidationTest {

    @Test
    void 입력된_숫자가_음수인지_판별() {
        assertTrue(Validation.isNegative(-43));
        assertFalse(Validation.isNegative(12));
    }

    @Test
    void 입력된_문자열이_숫자인지_판별() {
        assertTrue(Validation.isNum("123"));
        assertTrue(Validation.isNum("45"));
        assertFalse(Validation.isNum(" 56"));
        assertFalse(Validation.isNum(" "));
        assertFalse(Validation.isNum("hello"));
    }

    @Test
    void 입력된_문자열이_공백인지_판별() {
        assertTrue(Validation.isBlank("    "));
        assertTrue(Validation.isBlank(" "));
        assertTrue(Validation.isBlank(""));
        assertFalse(Validation.isBlank("hello "));
    }

    @Test
    void 입력된_문자열_중_공백이_포함되어_있는지_판별() {
        assertTrue(Validation.isBlankContain("    "));
        assertTrue(Validation.isBlankContain(" "));
        assertFalse(Validation.isBlankContain(""));
        assertTrue(Validation.isBlankContain("hello "));
    }

    @Test
    void 리스트의_원소들_중에_공백이_포함되어_있는지_판별() {
        assertTrue(Validation.isBlank(List.of("pobi", " woni")));
        assertTrue(Validation.isBlank(List.of("pobi", " ")));
        assertFalse(Validation.isBlank(List.of("pobi", "woni")));
        assertFalse(Validation.isBlank(List.of("pobi", "")));
    }

    @Test
    void 리스트의_원소들_중에_중복된_원소가_있는지_판별() {
        List<String> List1 = List.of("pobi", "woni", "woni");
        List<String> List2 = List.of("pobi", "woni", "crong");

        for (int i = 0; i < List1.size(); i++) {
            if (Validation.isDuplicates(List1, List1.get(i), i)) {
                assertTrue(Validation.isDuplicates(List1, List1.get(i), i));
            }
        }

        for (int i = 0; i < List2.size(); i++) {
            assertFalse(Validation.isDuplicates(List2, List2.get(i), i));
        }
    }

    @Test
    void 리스트의_각_원소의_크기가_5를_초과하는지_판별() {
        List<String> List1 = List.of("pobi", "woni", "crong");
        List<String> List2 = List.of("pobi", "woni", "crong", "honux", "thisis");

        assertFalse(Validation.isOverFiveWord(List1));
        assertTrue(Validation.isOverFiveWord(List2));
    }

    @Test
    void 리스트_자체가_빈_리스트인지_판별() {
        List<String> List1 = List.of("pobi", "woni", "crong");
        List<String> List2 = List.of();

        assertFalse(Validation.isEmpty(List1));
        assertTrue(Validation.isEmpty(List2));
    }

    @Test
    void 쉼표의_개수가_올바른지_판별() {
        String input = "a,b,c";
        List<String> list = List.of("a", "b", "c");
        assertTrue(Validation.isCorrectComma(list, input));

        String input2 = "a,,,,";
        List<String> list2 = List.of("a");
        assertFalse(Validation.isCorrectComma(list2, input));

        String input3 = "pobi,woni,crong";
        List<String> list3 = List.of("pobi", "woni", "crong");
        assertTrue(Validation.isCorrectComma(list3, input3));
    }
}

package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 하나의_값_만_들어올_때() {
        String input = "pobi";
        List<String> expected = Arrays.asList("pobi");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void 여러_정상_값이_있을_때() {
        String input = "pobi,woni,jun";
        List<String> expected = Arrays.asList("pobi", "woni", "jun");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void 빈_문자열_이_들어올_때() {
        String input = "";
        List<String> expected = Arrays.asList("");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void 첫_시작이_컴마일_때() {
        String input = ",pobi,jun";
        List<String> expected = Arrays.asList("", "pobi", "jun");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void 연속_컴마가_들어올_때() {
        String input = "pobi,,jun,aa";
        List<String> expected = Arrays.asList("pobi","","jun","aa");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void 띄어쓰기가_들어올때(){
        String input = "pobi, ,jun";
        List<String> expected = Arrays.asList("pobi", " ", "jun");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

}
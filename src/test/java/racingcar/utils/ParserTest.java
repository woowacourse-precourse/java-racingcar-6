package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParserTest {
    @Test
    void 쉼표를_기준으로_문자열_파싱() {
        // given
        String str = "첫번째,두번째,세번째";

        // when
        List<String> strings = Parser.parseStringList(str);

        // then
        Assertions.assertEquals(3, strings.size());
    }

    @Test
    void 쉼표_사이에_빈문자열이_있다면_빈문자열로_정상적으로_파싱() {
        // given
        String str = "fdf,,dfd";

        // when
        List<String> strings = Parser.parseStringList(str);

        // then
        Assertions.assertEquals(3, strings.size());
    }

    @Test
    void 쉼표가_없다면_하나의_문자열로_취급() {
        // given
        String str = "fdfdfd";

        // when
        List<String> strings = Parser.parseStringList(str);

        // then
        Assertions.assertEquals(1, strings.size());
    }

    @Test
    void 빈_문자열_파싱시_빈_문자열을_그대로_반환() {
        // given
        String str = "";

        // when
        List<String> strings = Parser.parseStringList(str);

        // then
        Assertions.assertEquals(1, strings.size());
        Assertions.assertEquals("", strings.get(0));
    }

    @Test
    void 문자열의_마지막이_쉼표로_끝나는_경우도_빈문자열을_입력한_것으로_판단() {
        // given
        String str = "fdfd,";

        // when
        List<String> strings = Parser.parseStringList(str);

        // then
        Assertions.assertEquals(2, strings.size());
    }

    @Test
    void 쉼표만_입력하더라도_쉽표를_기준으로_정상적으로_파싱() {
        // given
        String str = ",,";

        // when
        List<String> strings = Parser.parseStringList(str);

        // then
        Assertions.assertEquals(3, strings.size());
    }
}

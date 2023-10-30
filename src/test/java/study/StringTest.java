package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");

        // 특정 결과가 주어진 순서대로 "1"과 "2"를 포함하는지 확인
        assertThat(result).containsExactly("1", "2");
    }

    // TODO: 10/31/23 활용해보기.
    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @DisplayName("CsvSource을 이용한 테스트 활용")
    @ParameterizedTest
    @CsvSource({"abc,1,true", "def,2,false"})
    public void CsvSource_활용하여_여러개_테스트_확인하기(String str, int num, boolean isTrue) throws Exception {
        assertThat(str).contains(str);
        assertThat(num).isEqualTo(num);
        assertThat(isTrue).isEqualTo(isTrue);
    }

    @ParameterizedTest(name = "매개변수") // 무조건 name으로
    @ValueSource(strings = {"abc", "def", "ghi"})
    @DisplayName("ValueSource을 이용한 테스트 활용_1")
    void ValueSource_을_활용하여_여러개_테스트_확인하기_문자(String str) {
        assertThat(str).contains(str);
    }

    @ParameterizedTest(name = "매개변수") // 무조건 name으로
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ValueSource을 이용한 테스트 활용_2")
    void ValueSource_을_활용하여_여러개_테스트_확인하기_숫자(int num) {
        assertThat(num).isEqualTo(num);
    }

    @ParameterizedTest(name = "매개변수") // 무조건 name으로
    @ValueSource(booleans = {true, false})
    @DisplayName("ValueSource을 이용한 테스트 활용_3")
    void ValueSource_을_활용하여_여러개_테스트_확인하기_불(boolean isTrue) {
        assertThat(isTrue).isEqualTo(isTrue);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("NullSource, EmptySource의 에너테이션을 이용한 NULL, EMPTY 테스트")
    void NULL_EMPTY_을_활용한_테스트(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("NullAndEmptySource의 에너테이션을 이용한 NULL, EMPTY 테스트")
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void NullAndEmptySource_을_활용한_테스트(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }


    @DisplayName("assertThrows_을_이용한_예외를_테스트")
    @Test
    void assertThrows_을_이용한_예외를_테스트() {
        String input = "abc";

        // when then
        assertThrows(StringIndexOutOfBoundsException.class, () -> input.charAt(5));
    }

    @DisplayName("assertThatThrownBy_을_이용한_예외를_테스트")

    @Test
    public void assertThatThrownBy_을_이용한_예외를_테스트() {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }

    @DisplayName("assertThatExceptionOfType_을_이용한_예외를_테스트")
    @Test
    public void assertThatExceptionOfType_을_이용한_예외를_테스트() {
        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> {
                    throw new IOException("boom!");
                })
                .withMessage("%s!", "boom") // 예외 메시지가 "boom!"과 일치하는지 확인하고
                .withMessageContaining("boom") // 메시지에 "boom"이 포함되어 있는지 확인하고
                .withNoCause(); // 예외가 특정 원인을 갖지 않는지 확인한다.

//        코드에서 withMessage("%s!", "boom")는
//        문자열 "boom"을 %s 자리 표시자에 대체하고,
//        그 뒤에 느낌표를 추가하여 "boom!"이라는 문자열을 생성합니다.
    }

    @DisplayName("out_출력_확인_테스트")
    @Test
    void out_출력_확인_테스트() {
        // given
        // 출력을 위한 테스트
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        System.out.println();

        // than
        assertThat(outContent.toString()).isEqualTo("\n");
    }

    @DisplayName("List의_모든_원소에_대한_확인_하는_테스트")
    @Test
    public void List의_모든_원소에_대한_확인_하는_테스트() throws Exception {
        // given
        List<Integer> resultList = List.of(1, 1, 1, 1, 1);

        // then
        assertThat(resultList).allMatch((value) -> {
            return value.equals(1);
        });
    }
}

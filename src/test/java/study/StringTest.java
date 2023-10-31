package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @DisplayName("두개의_List가_같은지_확인하는_테스트")
    @Test
    void 두개의_List가_다른지_확인하는_테스트() throws Exception {
        //given
        List<Integer> resultList_1 = List.of(1, 2, 3);
        List<Integer> resultList_2 = List.of(3, 4, 5);

        // then
        // 방법 1 assertNotEquals
        assertNotEquals(resultList_1, resultList_2);
        // 방법 2 assertThat().isFalse
        assertThat(resultList_1.equals(resultList_2)).isFalse();
    }

    @DisplayName("두개의_List가_같은지_확인하는_테스트")
    @Test
    void 두개의_List가_같은지_확인하는_테스트() throws Exception {
        //given
        List<Integer> resultList_1 = List.of(1, 2, 3);
        List<Integer> resultList_2 = List.of(1, 2, 3);

        // then
        // 방법 1 assertEquals
        assertEquals(resultList_1, resultList_2);
        // 방법 2 assertThat().isTrue
        assertThat(resultList_1.equals(resultList_2)).isTrue();
    }

    @DisplayName("문자열_검증")
    @Test
    void 문자열_검증() {
        String expression = "This is a string";
        assertThat(expression).startsWith("This").endsWith("string").contains("a");
    }

    @DisplayName("EnumSource_을_이용한_ENUM_포함에_관한_테스트")
    @ParameterizedTest
//          value = Enum의 클래스 정의  names =  Enum의 값을 정의
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void EnumSource_을_이용한_ENUM_포함에_관한_테스트(TimeUnit inputTimeUnit) {
        assertTrue(
                EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(inputTimeUnit)
        );
    }

    @DisplayName("contains_을_활용한_하나라도_포함이_되어있으면_테스트_통과")
    @Test
    public void contains_을_활용한_하나라도_포함이_되어있으면_테스트_통과() throws Exception {
        String input = "1,,23";
        String[] result = input.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("1", "23");
    }

    @DisplayName("containsAnyOf_을_활용한_이중에_하나가_포함되어있으면_테스트_통과_1")
    @Test
    void containsAnyOf_을_활용한_이중에_하나가_포함되어있으면_테스트_통과_1() {
        assertThat("The Lord of the Rings")
                // 널이 아니고
                .isNotNull()
                // The로 시작하고
                .startsWith("The")
                // Lord가 포함하고
                .contains("Lord")
                .contains("of")
                // 이중에 하나가 포함되었다.
                .containsAnyOf("the", "rings")
                // 끝이 Rings이다.
                .endsWith("Rings");
    }

    @DisplayName("containsAnyOf_을_활용한_이중에_하나가_포함되어있으면_테스트_통과_1")
    @Test
    void containsAnyOf_을_활용한_이중에_하나가_포함되어있으면_테스트_통과_2() {
        assertThat("123")
                // 널이 아니고
                .isNotNull()
                // The로 시작하고
                .startsWith("1")
                // Lord가 포함하고
                .contains("3")
                .contains("2")
                // 이중에 하나가 포함되었다.
                .containsAnyOf("1", "aslkdjasd", "아무단어")
                // 끝이 Rings이다.
                .endsWith("3");
    }

    @DisplayName("containsExactly_을_활용한_정확한_순서로_리스트에_포함되어_있는가_테스트")
    @Test
    void containsExactly_을_활용한_정확한_순서로_리스트에_포함되어_있는가_테스트() {
        String input = "1,,23";
        String[] result = input.split(",");

        // 정확하게 들어있는가
        assertThat(result).containsExactly("1", "", "23");
    }

    @DisplayName("containsOnly_을_활용하여_원소값과_갯수가_정확히_일치_테스트")
    @Test
    public void containsOnly_을_활용하여_원소값과_갯수가_정확히_일치_테스트() throws Exception {
        List<String> list = List.of("apple", "banana", "orange", "americano");

        //  이름을 가져와서 a 가 포함되어 있는 객체들만 필터링을 하고 그 객체를 검증한다.
        assertThat(list)
                .filteredOn(value -> value.contains("apple")) // 'apple'를 포함하는 객체들을 필터링하고
                .containsOnly("apple"); // 'banana'과 'orange'만을 포함하는지 검증한다.
    }
}

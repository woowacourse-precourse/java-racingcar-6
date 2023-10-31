package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.StringAssert;
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

// https://assertj.github.io/doc/#overview-what-is-assertj
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

    @DisplayName("filterOn_을_활용하여_원소값과_갯수가_정확히_일치_테스트")
    @Test
    public void filterOn_필터링하고_객체_검증_일치_테스트() throws Exception {
        List<String> list = List.of("apple", "banana", "orange", "americano");

        //  이름을 가져와서 a 가 포함되어 있는 객체들만 필터링을 하고 그 객체를 검증한다.
        assertThat(list)
                .filteredOn(value -> value.contains("apple")) // 'apple'를 포함하는 객체들을 필터링하고
                .containsOnly("apple"); // 'banana'과 'orange'만을 포함하는지 검증한다.
    }

    @DisplayName("기본적인_assertions_사용법")
    @Test
    public void 기본적인_assertions_사용법() throws Exception {
        Human frodo = new Human("Frodo");
        Human sauron = new Human("Sauron");

        // basic assertions
        assertThat(frodo.getName()).isEqualTo("Frodo");
        assertThat(frodo).isNotEqualTo(sauron);

        // chaining string specific assertions
        assertThat(frodo.getName()).startsWith("Fro")
                .endsWith("do")
                .isEqualToIgnoringCase("frodo");
    }

    @DisplayName("collection_에_Assertions_적용하기")
    @Test
    public void collection_에_Assertions_적용하기() throws Exception {
        // given
        Human frodo = new Human("Frodo");
        Human sam = new Human("Sam");
        Human seung = new Human("Seung");
        Human chan = new Human("Chan");
        Human sauron = new Human("Sauron");

        List<Human> fellowshipOfTheRing = List.of(frodo, sam, seung, chan);

        // than
        assertThat(fellowshipOfTheRing).hasSize(4)
                .contains(frodo, sam)
                .doesNotContain(sauron);
    }

    @DisplayName("as_을_활용한_메세지보내기")
    @Test
    public void as_을_활용한_메세지보내기() throws Exception {
        // given
        Human frodo = new Human("Frodo");

        // then
        // as()는 테스트를 설명하는 데 사용되며 오류 메시지 앞에 표시됩니다.
        // 오류일때 as() 발동
        // ex) org.opentest4j.AssertionFailedError: [check Frodo's age]
        assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
        assertThat(frodo.getAge()).as("check %s's age", frodo.getAge()).isEqualTo(33);
        assertThat(frodo.getAge()).as("check %s's age", frodo.isTrue()).isEqualTo(33);
    }

    @DisplayName("Satisfy_을_활용한_assertions_List_확인하기")
    @Test
    public void Satisfy_을_활용한_assertions_List_확인하기() throws Exception {
        // given
        Human frodo = new Human("Frodo");
        Human sam = new Human("Sam");
        Human pippin = new Human("Pippin");

        List<Human> humansList = List.of(frodo, sam, pippin);

        // than
        // 모든 요소는 주어진 주장을 만족해야 합니다.
        assertThat(humansList).allSatisfy(human -> {
            assertThat(human.getName()).isNotEqualTo("Sauron");
        });

        // 최소한 하나의 요소가 주어진 주장을 만족해야 합니다.
        assertThat(humansList).anySatisfy(human -> {
            assertThat(human.getName()).isEqualTo("Sam");
        });

        // 어떤 요소도 주어진 주장을 만족해서는 안 됩니다.
        assertThat(humansList).noneSatisfy(human ->
                assertThat(human.getName()).isEqualTo("NOTTING")
        );
    }

    @DisplayName("allMatch_anyMatch_noneMatch_을_활용한_테스트")
    @Test
    public void allMatch_anyMatch_noneMatch_을_활용한_테스트() throws Exception {
        // given
        Human frodo = new Human("Frodo");
        Human sam = new Human("Sam");
        Human pippin = new Human("Pippin");

        List<Human> humansList = List.of(frodo, sam, pippin);

        // than
        assertThat(humansList).
                // 모든 요소는 주어진 주장을 만족해야 합니다.
                        allMatch(human -> human.getAge() == 33, "age")

                // 모든 요소는 주어진 주장을 만족해야 합니다.
                .allMatch(human -> human.getAge() == 33)

                // 최소한 하나의 요소가 주어진 주장을 만족해야 합니다.
                .anyMatch(character -> character.getName().contains("pp"))

                // 어떤 요소도 주어진 주장을 만족해서는 안 됩니다.
                .noneMatch(character -> character.getName() == "NOTTING");
    }

    @DisplayName("element_index_을_활용한_테스트")
    @Test
    public void element_index_을_활용한_테스트() throws Exception {
        // given
        Human frodo = new Human("Frodo");
        Human sam = new Human("Sam");
        Human pippin = new Human("Pippin");

        List<Human> humansList = List.of(frodo, sam, pippin);

        // then
        // index을 활용한 List 탐색
        assertThat(humansList).first().isEqualTo(frodo);
        assertThat(humansList).element(1).isEqualTo(sam);
        assertThat(humansList).last().isEqualTo(pippin);

        // 강력한 문자열 TYPE Assertions 테스트
        Iterable<String> humanName = List.of("frodo", "sam", "pippin");

        // STRING is 문자표식
        // as()은 가독성을 위한 표식
        assertThat(humanName).first(as(STRING))
                .startsWith("fro")
                .endsWith("do");

        assertThat(humanName).element(1, as(STRING))
                .startsWith("sa")
                .endsWith("am");

        assertThat(humanName).last(as(STRING))
                .startsWith("pip")
                .endsWith("pin");

        // 강력한 TYPE Assertions 테스트
        assertThat(humanName, StringAssert.class).first()
                .startsWith("fro")
                .endsWith("do");
    }

    @DisplayName("단일_요소_list_의_테스트_방법")
    @Test
    public void 단일_요소_list_의_테스트_방법() throws Exception {
        // given
        List<String> oneList = List.of("Maggie");

        // then
        // 단일 요소의 리스트인지 확인한다.
        assertThat(oneList).singleElement()
                .isEqualTo("Maggie");

        // 단일 요소의 리스트 확인 => 문자열 테스트.
        assertThat(oneList).singleElement(as(STRING))
                .endsWith("gie");

        // 단일 요소확인 => 문자열 TYPE 확인
        assertThat(oneList, StringAssert.class).singleElement()
                .startsWith("Mag");
    }

    @DisplayName("속성_property_필드_field_in_notIn_not_값을_확인하는_메서드_테스트")
    @Test
    public void 속성_property_필드_field_in_notIn_not_값을_확인하는_메서드_테스트() throws Exception {
        // given
        Human frodo = new Human("Frodo");
        Human frodo2 = new Human("Frodo2");
        Human sam = new Human("Sam");
        Human sam2 = new Human("Sam2");
        Human pippin = new Human("Pippin");
        Human pippin2 = new Human("Pippin2", 12);

        List<Human> humansList = List.of(frodo, sam, pippin, frodo2, sam2, pippin2);

        // then
        // filter을 사용을 한다. 속성의 이름(property), 멤버 변수(field)의 이름정의
        assertThat(humansList).filteredOn("age", 33)
                .filteredOn("name", "Frodo")
                .containsOnly(frodo);

//        // filter에서 여러 속성 확인하는 방법 notIn()
        assertThat(humansList)
                .filteredOn("name", notIn("Sam", "Sam2", "Pippin", "Pippin2"))
                .containsOnly(frodo, frodo2);

        // filter에서 여러 속성 확인하는 방법 in()
        assertThat(humansList).filteredOn("name", in("Frodo", "Frodo2"))
                .containsOnly(frodo, frodo2);

        // filter에서 하나만 아니다.
        assertThat(humansList).filteredOn("name", not("Sam"))
                .containsOnly(frodo, pippin, frodo2, sam2, pippin2);

//        // 여러 필드 사용하기.
        assertThat(humansList).filteredOn("name", "Pippin")
                .filteredOn("age", not(12))
                .containsOnly(pippin);
    }
}

class Human {
    private String name;
    private int age;
    private boolean isTrue;

    public Human(String name) {
        this.name = name;
        age = 33;
        isTrue = true;
    }

    public Human(String name, int age) {
        this.name = name;
        age = age;
        isTrue = true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isTrue() {
        return isTrue;
    }

    @Override
    public String toString() {
        return name;
    }
}

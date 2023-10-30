package racingcar.utill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UtillTest {
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("숫자 변환 테스트")
    @Test
    void parseInteger() {
        // given
        String input = "123";

        // when
        Integer result = Utill.parseInteger(input);

        // than
        assertThat(result).isEqualTo(123);
    }

    @DisplayName("string을 regex의 기준으로 구분을 하여 배열로 반환 테스트")
    @Test
    void makeSplitArrFromString() {
        // given
        String str = "one,two,three";
        String regex = ",";

        // when
        String[] resultArr = Utill.makeSplitArrFromString(str, regex);

        // than
        assertThat(resultArr).isEqualTo(new String[]{"one", "two", "three"});
    }

    @DisplayName("print new Line 테스트")
    @Test
    void printNewLine() {
        // when
        Utill.printNewLine();

        // than
        assertThat(outContent.toString()).isEqualTo("\n");
    }

    @DisplayName("print 메서드 테스트")
    @Test
    void print() {
        // given
        String input = "input";

        // when
        Utill.print(input);

        // than
        assertThat(outContent.toString()).isEqualTo("input\n");
    }

    @DisplayName("배열을 리스트로 만들어준다. 테스트")
    @Test
    void makeListFromArr() {
        // given
        Integer[] inputArr = new Integer[]{1, 2, 3};
        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(3);

        // when
        List<Integer> resultList = Utill.makeListFromArr(inputArr);

        // than
        assertThat(resultList).isEqualTo(targetList);

    }

    @DisplayName("num_1 과 num_2의 숫자가 같으면 true 테스트")
    @Test
    void isSameNum() {
        // given

        // when

        // than
    }

    @DisplayName("값이 1이상인지 확인한다. 테스트")
    @Test
    void valueGreaterThanEqualOne() {
        // given

        // when

        // than
    }
}
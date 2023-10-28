package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarCreatorTest {

    private static CarCreator carCreator;

    @BeforeAll
    public static void setup(){ carCreator = new CarCreator();}

    @ParameterizedTest
    @DisplayName("문자열을 , 기준으로 자릅니다")
    @MethodSource("playerInputAndExpectedListProvider")
    public void 문자열_쉼표_기준_자르기(String playerInput, List<String> expectedList){
        //when
        List<String> actualList = carCreator.splitPlayerInput(playerInput);

        //then
        assertThat(actualList).isEqualTo(expectedList);
    }

    static Stream<Arguments> playerInputAndExpectedListProvider(){
        return Stream.of(
                Arguments.arguments("", Collections.emptyList()),
                Arguments.arguments("pobbi", Arrays.asList("pobbi")),
                Arguments.arguments("pobbi,wonni,jun", Arrays.asList("pobbi", "wonni", "jun"))
        );
    }
}

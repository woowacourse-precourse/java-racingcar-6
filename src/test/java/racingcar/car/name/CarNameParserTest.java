package racingcar.car.name;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameParserTest {

    private CarNameParser parser;

    @BeforeEach
    void setUp() {
        parser = new CarNameParser();
    }

    @DisplayName("CarNameParser 성공")
    @Test
    void parseMethod_success() {
        String input = "pobi,woni,jun";
        List<CarName> result = parser.parse(input);

        assertEquals(3, result.size());
        assertEquals("pobi", result.get(0).name());
        assertEquals("woni", result.get(1).name());
        assertEquals("jun", result.get(2).name());
    }

    @DisplayName("CarNameParser 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u",
            "",
            "valid1,valid2,invalidcarname"
    })
    void parseMethod_invalidInput_throwException(String input) {
        assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
    }
}

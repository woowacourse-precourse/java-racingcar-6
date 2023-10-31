package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import racingcar.model.CarName;

@DisplayName("자동차 이름 테스트")
public class CarNameTest {
    CarName carName = new CarName();

    @DisplayName("입력 -> 자동차 리스트")
    @Test
    void 자동차이름_세팅() {
        //given
        String input = ("pobi,woni,jun");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<String>() {{
            add("pobi");
            add("woni");
            add("jun");
        }};
        //when
        carName.carNamesToList(input);
        carName.setClearCarList();
        result = carName.getClearCarList();
        //then
        for (int i = 0; i < answer.size(); i++) {
            assertEquals(result.get(i), answer.get(i));
        }
    }

    @DisplayName("예외처리-자동차이름")
    @Test
    void 자동차이름_알파벳_아닐때() {
        CarName carName = new CarName();
        String input = ("1,woni,jun");

        carName.carNamesToList(input);

        Throwable exception = assertThrows(IllegalArgumentException.class, carName::setClearCarList);
        assertEquals("자동차 이름은 알파벳이여야 합니다.", exception.getMessage());
    }

    @DisplayName("예외처리-자동차이름 중복")
    @Test
    void 중복_중복된_자동차_이름() {
        CarName carName = new CarName();
        String input = ("woni,woni,jun");
        carName.carNamesToList(input);
        Throwable exception = assertThrows(IllegalArgumentException.class, carName::setClearCarList);
        assertEquals("중복된 자동차 이름은 허용되지 않습니다.", exception.getMessage());
    }

    @DisplayName("예외처리-자동차이름 길이 ")
    @Test
    public void 자동차_이름_6이상() {
        CarName carName = new CarName();
        String input = ("pobbbbbbi,woni,jun");
        carName.carNamesToList(input);
        Throwable exception = assertThrows(IllegalArgumentException.class, carName::setClearCarList);
        assertEquals("자동차 이름의 길이는 5 이하여야 합니다.", exception.getMessage());
    }

    @Nested
    @DisplayName("예외처리-구분자")
    @Test
    public void 구분자가_쉼표_아님() {
        CarName carName = new CarName();
        String input = ("pobi!woni,jun");
        carName.carNamesToList(input);
        Throwable exception = assertThrows(IllegalArgumentException.class, carName::setClearCarList);
        assertEquals("구분자는 자동차 이름 사이의 쉼표입니다.", exception.getMessage());
    }
}


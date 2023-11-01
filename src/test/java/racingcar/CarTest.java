package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

public class CarTest {
    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarList();
    }

    @Test
    void 객체생성검증() {
        carList.add("하루하루");
    }

    @Test
    void 글자제한수_예외처리검증() {
        String invalidName = "이건절대안돼";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carList.add(invalidName);
        });
    }

    @Test
    void 공백_예외처리검증() {
        String invalidName = "  ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carList.add(invalidName);
        });
    }

    @Test
    void 입력이름_전처리검증() {
        String dirtyName = "나 는 엉 뚱 해";
        assertThat(carList.nameCleaner(dirtyName)).isEqualTo("나는엉뚱해");
    }
}

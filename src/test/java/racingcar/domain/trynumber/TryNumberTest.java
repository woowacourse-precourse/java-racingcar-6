package racingcar.domain.trynumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {
    private TryNumber tryNumber;

    @BeforeEach
    void 시도_횟수_설정(){
        tryNumber = new TryNumber();
    }

    @Test
    void 시도할_횟수_유효성_테스트(){
        assertThatThrownBy(() -> {
            tryNumber.setTryNumber("test");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
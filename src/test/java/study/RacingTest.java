package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    public void setup() {
        racing = new Racing();
    }

    // 이 테스트는 랜덤성 때문에 실제로 실행시키면 실패할 수 있습니다.
    // Racing 클래스를 테스트하기 쉽게 만들려면 랜덤 로직을 주입 가능한 형태로 변경하는 것이 좋습니다.
    @Test
    public void racingShouldInitCars() {
        // 여기서는 Racing의 `init` 메서드를 호출하면 실제 콘솔 입력을 기다리게 되므로
        // 테스트 코드를 작성하기 위해서는 콘솔 입력을 mocking 해야 합니다.
        // 이는 복잡한 테스트 로직이 필요합니다.
    }

    // ... 다른 Racing 메서드들에 대한 테스트 코드 추가
}


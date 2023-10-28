package study.random.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @DisplayName("uhanuu가 아니라, haen이 나오면, 테스트를 통과한다.")
    @Test
    void carNameTest() {
        // mocking 전
        assertThat(OtherClass.getCarName()).isEqualTo("uhanuu");

        //Try-with-resource
        try (MockedStatic<CarName> carName = Mockito.mockStatic(CarName.class)) {
            BDDMockito.given(CarName.getName()).willReturn("haen");
            assertThat(OtherClass.getCarName()).isEqualTo("haen");
        }
    }
}

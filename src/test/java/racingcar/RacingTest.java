package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    private static Racing racing;

    @BeforeEach
    void init() {
        racing = new Racing();
    }

    @Test
    @DisplayName("initParticipants 이름 길이 초과 실패 테스트")
    void initParticipants_name_length_over_fail() {

        String[] carNames = {"디카프리오", "레옹", "인텔리제이짱짱맨"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 이름 길이 부족 실패 테스트")
    void initParticipants_name_length_lack_fail() {

        String[] carNames = {"", "레옹", "인텔리제이"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 이름 중복 실패 테스트")
    void initParticipants_name_duplication_fail() {

        String[] carNames = {"디카프리오", "디카프리오", "레옹"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 참여자 초과 실패 테스트")
    void initParticipants_participants_over_fail() {

        String[] carNames = {"디카프리오", "레옹", "마틸다", "로즈", "고든", "레이첼"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 검증 테스트")
    void initParticipants_success() {

        String[] carNames = {"디", "레옹", "마틸다", "로즈", "고든"};

        racing.initParticipants(carNames);

        assertThat(racing.getCarNames()).contains("디", "레옹", "마틸다", "로즈", "고든");

        List<Car> result = racing.getParticipants();

        for (int i = 0; i < result.size(); i++) {
            Car car = result.get(i);
            assertThat(car.toString()).contains(carNames[i]);
        }
    }

    
    
    @Test
    @DisplayName("initPlayCount 부족 실패 테스트")
    void initPlayCount_lack_fail() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initPlayCount(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initPlayCount 초과 실패 테스트")
    void initPlayCount_over_fail() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initPlayCount(11))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initPlayCount 검증 테스트")
    void initPlayCount_success() {

        racing.initPlayCount(5);
        assertThat(racing.getPlayCount()).isEqualTo(5);
    }



    @Test
    @DisplayName("getPlayResults 검증 테스트")
    void getPlayResults_validate() {

        String[] carNames = {"디", "레옹", "마틸다", "로즈", "고든"};
        int playCount = 5;

        racing.initParticipants(carNames);
        racing.initPlayCount(playCount);

        String result = String.join(
                "\n",
                racing.getPlayResults()
        );

        assertThat(result).contains("디 : ", "레옹 : ", "마틸다 : ", "로즈 : ", "고든 : ", "-");
    }
}

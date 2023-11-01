package racingcar.domain;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.dto.CarStatusDto;

class ParticipantTest {
    private static MockedStatic<Randoms> randoms;
    private static int SUCCESS_VALUE = 4;
    private static int FAIL_VALUE = 3;

    @BeforeAll
    public static void beforeTest() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterTest() {
        randoms.close();
    }

    @Test
    void from() {
        //given
        List<String> exampleCar = List.of("배달이", "동준이", "민족이");
        Participant participant = Participant.from(exampleCar);
        //when
        List<CarStatusDto> carStatusDtoList = participant.generateCarStatus();
        List<String> expectCar = carStatusDtoList.stream()
                .map(CarStatusDto::name)
                .toList();
        //then
        Assertions.assertThat(expectCar.get(0)).isEqualTo(exampleCar.get(0));
        Assertions.assertThat(expectCar.get(1)).isEqualTo(exampleCar.get(1));
        Assertions.assertThat(expectCar.get(2)).isEqualTo(exampleCar.get(2));
    }

    @Nested
    class tryProgress {
        @DisplayName("전진에 성공할 시, 각각의 car 객체의 progressScore에 1값이 추가됩니다.")
        @Test
        void tryProgressSuccess() {
            //given
            given(Randoms.pickNumberInRange(Progress.MINIMUM_RANGE_NUMBER, Progress.MAXIMUM_RANGE_NUMBER))
                    .willReturn(SUCCESS_VALUE);
            List<String> exampleCar = List.of("배달이", "동준이", "민족이");
            Participant participant = Participant.from(exampleCar);
            participant.tryProgress();
            //when
            List<CarStatusDto> carStatusDtoList = participant.generateCarStatus();
            int expectResult = (int) carStatusDtoList.stream()
                    .filter(dto -> dto.score() == 1)
                    .count();
            //then
            Assertions.assertThat(expectResult).isEqualTo(3);
        }

        @DisplayName("전진에 실패할 시, 각각의 car 객체의 progressScore에 0값이 추가됩니다.")
        @Test
        void tryProgressFail() {
            //given
            given(Randoms.pickNumberInRange(Progress.MINIMUM_RANGE_NUMBER, Progress.MAXIMUM_RANGE_NUMBER))
                    .willReturn(FAIL_VALUE);
            List<String> exampleCar = List.of("배달이", "동준이", "민족이");
            Participant participant = Participant.from(exampleCar);
            participant.tryProgress();
            //when
            List<CarStatusDto> carStatusDtoList = participant.generateCarStatus();
            int expectResult = (int) carStatusDtoList.stream()
                    .filter(dto -> dto.score() == 0)
                    .count();
            //then
            Assertions.assertThat(expectResult).isEqualTo(3);
        }
    }
}
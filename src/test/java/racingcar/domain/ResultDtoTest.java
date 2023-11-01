package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.TestConsts.TOTAL_ROUND;

class ResultDtoTest {

    public static final int FIRST_ROUND = 1;
    public static final int SECOND_ROUND = 2;
    public static final int THIRD_ROUND = 3;
    public static final int FOURTH_ROUND = 4;
    public static final int ONE_HUNDREDTH_ROUND = 100;

    private ResultDto resultDto;

    @BeforeEach
    @DisplayName("각 테스트 실행 전 데이터 저장")
    void addData() {
        // given
        resultDto = new ResultDto(TOTAL_ROUND);
        Car pobiCar = Car.createCar("pobi");
        Car woniCar = Car.createCar("woni");
        Car junCar = Car.createCar("jun");

        // when
        for (int i = FIRST_ROUND; i < TOTAL_ROUND + 1; i++) {
            List<Car.CarResultDto> carResults = Arrays.asList(
                    pobiCar.createCarResultDto(),
                    woniCar.createCarResultDto(),
                    junCar.createCarResultDto());
            SingleRoundResultDto singleRoundResult = new SingleRoundResultDto(carResults);
            resultDto.addSingleRoundResult(i, singleRoundResult);
        }
    }

    @Test
    @DisplayName("저장한 순서대로 자동차들이 SingleRoundResultDto에 저장되어 있다.")
    void getCarResultFromSingleResultDto() {
        // then
        SingleRoundResultDto findSingleRoundDto = resultDto
                .getSingleRoundResultDto(FIRST_ROUND);
        assertThat(findSingleRoundDto)
                .isExactlyInstanceOf(SingleRoundResultDto.class);

        Car.CarResultDto carResult = findSingleRoundDto.getCarResultDto(0);
        assertThat(carResult.name()).isEqualTo("pobi");

        Car.CarResultDto carResult2 = findSingleRoundDto.getCarResultDto(1);
        assertThat(carResult2.name()).isEqualTo("woni");

        Car.CarResultDto carResult3 = findSingleRoundDto.getCarResultDto(2);
        assertThat(carResult3.name()).isEqualTo("jun");
    }

    @Test
    @DisplayName("저장한 순서대로 SingleRoundResultDto들이 저장되어 있다.")
    void getSingleRoundResultDto() {
        // then
        assertThat(resultDto.getSingleRoundResultDto(FIRST_ROUND))
                .isNotNull();
        assertThat(resultDto.getSingleRoundResultDto(SECOND_ROUND))
                .isNotNull();
        assertThat(resultDto.getSingleRoundResultDto(THIRD_ROUND))
                .isNotNull();
    }

    @Test
    @DisplayName("저장되지 않은 라운드의 SingleRoundResultDto를 조회하면 null이 반환된다.")
    void ifTryGetNullResult() {
        assertThat(resultDto.getSingleRoundResultDto(FOURTH_ROUND))
                .isNull();
        assertThat(resultDto.getSingleRoundResultDto(ONE_HUNDREDTH_ROUND))
                .isNull();
    }

    @Test
    @DisplayName("자동차 경주 결과가 아무리 저장되든 최종 라운드에 대한 데이터는 그대로 저장돼있다.")
    void getFinalRound() {
        assertThat(resultDto.getFinalRound())
                .isEqualTo(TOTAL_ROUND);
    }
}
package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultDtoTest {

    public static final long TOTAL_ROUND = 3L;
    public static final int FIRST_ROUND = 1;
    private static BigInteger idProvider = BigInteger.ZERO;
    private ResultDto resultDto;

    @BeforeEach
    @DisplayName("각 테스트 실행 전 데이터 저장")
    void addData() {
        // given
        resultDto = new ResultDto(BigInteger.valueOf(TOTAL_ROUND));
        Car pobiCar = Car.createCar(generateId(), "pobi");
        Car woniCar = Car.createCar(generateId(), "woni");
        Car junCar = Car.createCar(generateId(), "jun");

        // when
        for (int i = FIRST_ROUND; i < TOTAL_ROUND + 1; i++) {
            List<Car.CarResultDto> carResults = Arrays.asList(
                    pobiCar.createCarResultDto(),
                    woniCar.createCarResultDto(),
                    junCar.createCarResultDto());
            SingleRoundResultDto singleRoundResult = new SingleRoundResultDto(carResults);
            resultDto.addSingleRoundResult(BigInteger.valueOf(i), singleRoundResult);
        }
    }

    private static BigInteger generateId() {
        return idProvider = idProvider.add(BigInteger.ONE);
    }

    @Test
    @DisplayName("저장한 순서대로 자동차들이 SingleRoundResultDto에 저장되어 있다.")
    void getCarResultFromSingleResultDto() {
        // then
        SingleRoundResultDto findSingleRoundDto = resultDto
                .getSingleRoundResultDto(BigInteger.ONE);
        assertThat(findSingleRoundDto)
                .isExactlyInstanceOf(SingleRoundResultDto.class);

        Car.CarResultDto carResult = findSingleRoundDto.getCarResultDto(0);
        assertThat(carResult.getName()).isEqualTo("pobi");

        Car.CarResultDto carResult2 = findSingleRoundDto.getCarResultDto(1);
        assertThat(carResult2.getName()).isEqualTo("woni");

        Car.CarResultDto carResult3 = findSingleRoundDto.getCarResultDto(2);
        assertThat(carResult3.getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("저장한 순서대로 SingleRoundResultDto들이 저장되어 있다.")
    void getSingleRoundResultDto() {
        // then
        assertThat(resultDto.getSingleRoundResultDto(BigInteger.valueOf(1)))
                .isNotNull();
        assertThat(resultDto.getSingleRoundResultDto(BigInteger.valueOf(2)))
                .isNotNull();
        assertThat(resultDto.getSingleRoundResultDto(BigInteger.valueOf(3)))
                .isNotNull();
    }

    @Test
    @DisplayName("저장되지 않은 라운드의 SingleRoundResultDto를 조회하면 null이 반환된다.")
    void ifTryGetNullResult() {
        assertThat(resultDto.getSingleRoundResultDto(BigInteger.valueOf(4)))
                .isNull();
        assertThat(resultDto.getSingleRoundResultDto(BigInteger.valueOf(100)))
                .isNull();

    }

    @Test
    @DisplayName("자동차 경주 결과가 아무리 저장되든 최종 라운드에 대한 데이터는 그대로 저장돼있다.")
    void getFinalRound() {
        assertThat(resultDto.getFinalRound())
                .isEqualTo(TOTAL_ROUND);
    }
}
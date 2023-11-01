package racingcar.repository;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;
import racingcar.util.TestConsts;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {

    private static final String TEMP_CLIENT_ROUND = "3";
    private static final int TOTAL_ROUND = 3;
    private static final int ONE_ROUND = 1;

    private CarRepository carRepository;

    @BeforeEach
    @DisplayName("리포지토리를 매번 테스트 실행 전마다 생성")
    void createCarRepository() {
        // given
        String inputtedCarNames = "pobi,woni,jun";
        CarsDto carsDto = new CarsDto(inputtedCarNames);
        Client client = new Client(TEMP_CLIENT_ROUND);

        // when
        carRepository = new CarRepository(carsDto, client);
    }

    @Test
    @DisplayName("RacingCars 생성")
    void checkCreatedRepository() {
        assertThat(carRepository).isExactlyInstanceOf(CarRepository.class);
    }

    @Test
    @DisplayName("리포지토리는 ResultDto를 한 번에 반환한다.")
    void returnFinalResultDto() {
        ResultDto resultDto = carRepository.finishFinalRound();
        assertThat(resultDto).isExactlyInstanceOf(ResultDto.class);
        assertThat(resultDto.getFinalRound()).isEqualTo(TEMP_CLIENT_ROUND);
    }

    @Test
    @DisplayName("리포지토리는 자체적으로 현재 몇 라운드인지도 보관하고, 마지막 경기인지도 판단할 수 있다.")
    void checkIsFinalRound() {
        assertThat(carRepository.isFinalRound()).isFalse();
        for (int i = ONE_ROUND; i < TOTAL_ROUND + 1; i++) {
            carRepository.race(BigInteger.valueOf(i));
        }
        assertThat(carRepository.isFinalRound()).isTrue();
    }

    @Test
    @DisplayName("리포지토리에서 최종 라운드 결과를 반환하기 전에 최종 우승자들도 계산해서 ResultDto를 반환한다.")
    void calculateWinners() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    carRepository.race(BigInteger.ONE);
                    ResultDto result = carRepository.finishFinalRound();
                    assertThat(result.getFinalWinners())
                            .containsExactly("pobi", "jun");
                }, TestConsts.FORWARD, TestConsts.STOP, TestConsts.FORWARD
        );
    }
}
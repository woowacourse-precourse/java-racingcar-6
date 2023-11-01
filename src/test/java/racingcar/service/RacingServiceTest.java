package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;
import racingcar.domain.SingleRoundResultDto;
import racingcar.domain.Car;
import racingcar.util.TestConsts;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private static final String TEMP_CLIENT_ROUND = "1";
    private static final int TEMP_CLIENT_ROUND_VALUE = 1;
    RacingService racingService;

    @BeforeEach
    @DisplayName("각 테스트 실행 전 RacingService 초기화")
    void initRacingService() {
        String inputtedCarNames = "pobi,woni,jun";
        CarsDto carsDto = new CarsDto(inputtedCarNames);
        Client client = new Client(TEMP_CLIENT_ROUND);

        racingService = new RacingService(carsDto, client);
    }

    @Test
    @DisplayName("playCarRacing()은 ResultDto를 반환하고, 그 안에는 차들의 이름 정보가 들어가있다.")
    void inquiryCarNamesFromResultDto() {
        ResultDto result = racingService.playCarRacing();
        SingleRoundResultDto singleRoundResult = result.getSingleRoundResultDto(TEMP_CLIENT_ROUND_VALUE);

        Car.CarResultDto pobiCar = singleRoundResult.getCarResultDto(0);
        assertThat(pobiCar.name()).isEqualTo("pobi");
        Car.CarResultDto woniCar = singleRoundResult.getCarResultDto(1);
        assertThat(woniCar.name()).isEqualTo("woni");
        Car.CarResultDto junCar = singleRoundResult.getCarResultDto(2);
        assertThat(junCar.name()).isEqualTo("jun");
    }

    @Test
    @DisplayName("playCarRacing()은 ResultDto를 반환하고, 그 안에는 차들의 이동한 거리 정보가 들어가있다.")
    void playMovingCarRacing() {
        assertRandomNumberInRangeTest(() -> {
                    ResultDto result = racingService.playCarRacing();
                    SingleRoundResultDto singleRoundResult = result.getSingleRoundResultDto(TEMP_CLIENT_ROUND_VALUE);

                    Car.CarResultDto pobiCar = singleRoundResult.getCarResultDto(0);
                    assertThat(pobiCar.distance()).isEqualTo(1L);
                    Car.CarResultDto woniCar = singleRoundResult.getCarResultDto(1);
                    assertThat(woniCar.distance()).isEqualTo(1L);
                    Car.CarResultDto junCar = singleRoundResult.getCarResultDto(2);
                    assertThat(junCar.distance()).isEqualTo(1L);
                }, TestConsts.FORWARD, TestConsts.FORWARD, TestConsts.FORWARD
        );
    }

    @Test
    @DisplayName("playCarRacing()은 ResultDto를 반환하고, 그 안에는 차들이 이동하지 않으면 정지한 거리 정보가 들어있다.")
    void playStoppedCarRacing() {
        assertRandomNumberInRangeTest(() -> {
                    ResultDto result = racingService.playCarRacing();
                    SingleRoundResultDto singleRoundResult = result.getSingleRoundResultDto(TEMP_CLIENT_ROUND_VALUE);

                    Car.CarResultDto pobiCar = singleRoundResult.getCarResultDto(0);
                    assertThat(pobiCar.distance()).isEqualTo(0L);
                    Car.CarResultDto woniCar = singleRoundResult.getCarResultDto(1);
                    assertThat(woniCar.distance()).isEqualTo(0L);
                    Car.CarResultDto junCar = singleRoundResult.getCarResultDto(2);
                    assertThat(junCar.distance()).isEqualTo(0L);
                }, TestConsts.STOP, TestConsts.STOP, TestConsts.STOP
        );
    }
}
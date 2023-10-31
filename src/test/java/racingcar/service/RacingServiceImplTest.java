package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingRepository;

public class RacingServiceImplTest {

    Config config = AppConfig.getInstance();
    private CarRepository carRepository = config.carRepository();
    private RacingRepository racingRepository = config.racingRepository();
    RacingService racingService = config.racingService();

    @BeforeEach
    public void setUp() {
        carRepository.deleteAll();
    }

    @Test
    public void 차이름과_시도횟수_정제해서_Racing객체_만들기() {
        // given
        String input = "pobi,woni,jun";
        String tryCount = "5";

        // when
        final Racing result = racingService.generateRacing(input, tryCount);

        // then
        assertThat(result).isNotNull();
        assertThat(result.participationSize()).isEqualTo(3);
        assertThat(result.getTryCount()).isEqualTo(5);
    }

    @Test
    public void Racing객체_저장하기() {
        // given
        String input = "pobi,woni,jun";
        String tryCount = "5";
        final Racing racing = racingService.generateRacing(input, tryCount);

        // when
        final Racing result = racingService.save(racing);

        // then
        assertThat(result).isSameAs(racing);
    }

    @Test
    public void Car_Name_미입력시_예외발생() {
        // given
        String input = "";
        String tryCount = "5";

        // when && then
        assertThatThrownBy(() -> racingService.generateRacing(input, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void Car_Name_공백입력시_예외발생() {
        // given
        String input = " ";
        String tryCount = "5";

        // when && then
        assertThatThrownBy(() -> racingService.generateRacing(input, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void Car_Name_콤마만_입력시_예외발생() {
        // given
        String input = ", , ,,";
        String tryCount = "5";

        System.out.println(Arrays.toString(input.split(",")));
        System.out.println((input.split(",").length));

        // when && then
        assertThatThrownBy(() -> racingService.generateRacing(input, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

/*
    @Test
    public void 시도횟수_정수하나_입력받아_저장하기() {
        // given
        String input = "3";

        // when
        racingService.processTryCountInput(input);

        // then

    }*/


}

package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.Car;
import racingcar.domain.Participations;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingGameRepository;

public class RacingGameServiceImplTest {

    Config config = AppConfig.getInstance();
    private CarRepository carRepository = config.carRepository();
    RacingGameService racingGameService = config.racingService();

    @BeforeEach
    public void setUp() {
        carRepository.deleteAll();
    }

    @Test
    public void 차이름과_시도횟수_정제해서_Racing객체_만들기() {
        // given
        String carNames = "pobi,woni,jun";
        String tryCount = "5";

        // when
        final RacingGame result = racingGameService.generateRacing(carNames, tryCount);

        // then
        assertThat(result).isNotNull();
        assertThat(result.calcParticipationSize()).isEqualTo(3);
        assertThat(result.getTryCount()).isEqualTo(5);
    }

    @Test
    public void Racing객체_저장하기() {
        // given
        String carNames = "pobi,woni,jun";
        String tryCount = "5";
        final RacingGame racingGame = racingGameService.generateRacing(carNames, tryCount);

        // when
        final RacingGame result = racingGameService.save(racingGame);

        // then
        assertThat(result).isSameAs(racingGame);
    }

    @Test
    public void 자동차이름들_미입력시_예외발생() {
        // given
        String carNames = "";
        String tryCount = "5";

        // when && then
        assertThatThrownBy(() -> racingGameService.generateRacing(carNames, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void 자동차이름들_공백입력시_예외발생() {
        // given
        String carNames = " ";
        String tryCount = "5";

        // when && then
        assertThatThrownBy(() -> racingGameService.generateRacing(carNames, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void 자동차이름들_콤마만_입력시_예외발생() {
        // given
        String carNames = ", , ,,";
        String tryCount = "5";

        // when && then
        assertThatThrownBy(() -> racingGameService.generateRacing(carNames, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void 시도횟수_정수가아닌_문자일시_예외발생() {
        // given
        String carNames = "pobi,woni,jun";
        String tryCount = "k";

        // when && then
        assertThatThrownBy(() -> racingGameService.generateRacing(carNames, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 시도횟수_정수범위_벗어난_숫자일시_예외발생() {
        // given
        String carNames = "pobi,woni,jun";
        String tryCount = "2200000000";

        // when && then
        assertThatThrownBy(() -> racingGameService.generateRacing(carNames, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 시도횟수만큼_각Car에_랜덤정수넣기() {
        // given
        String carNames = "pobi,woni,jun";
        String tryCount = "5";
        final RacingGame racingGame = racingGameService.generateRacing(carNames, tryCount);

        // when
        racingGameService.decideRandomMoveCondition(racingGame);

        // then
        racingGame.getParticipationsList()
                .forEach( car -> assertThat(car.calcPickedNumberSize()).isEqualTo(5));
    }

    @Test
    public void 단일_우승자_계산하기() {
        // given
        Car pobi = Car.create("pobi");
        pobi.insertPickedNumber(1);
        pobi.insertPickedNumber(2);

        Car woni = Car.create("woni");
        woni.insertPickedNumber(1);
        woni.insertPickedNumber(4);

        List<Car> carList = new ArrayList<>() {{
           add(pobi);
           add(woni);
        }};

        Participations participations = Participations.create(carList);

        int tryCount = 2;
        Winners winners = Winners.createEmpty();
        RacingGame racingGame = RacingGame.create(participations, tryCount, winners);

        List<Car> winnerList =  new ArrayList<>() {{
            add(woni);
        }};

        // when
        racingGameService.calculateWinners(racingGame);

        // then
        assertThat(racingGame.calcWinnerSize()).isEqualTo(1);
        assertThat(racingGame.getWinnerList()).isEqualTo(winnerList);
    }

    //TODO: 우승자 없는 경우, 공동 우승자 테스트
}
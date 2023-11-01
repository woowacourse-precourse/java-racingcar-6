package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.racing.TryCount;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.Participations;
import racingcar.domain.racing.RacingGame;
import racingcar.domain.racing.Winners;
import racingcar.repository.CarRepository;

public class RacingGameServiceImplTest {

    Config config = AppConfig.getInstance();
    private CarRepository carRepository = config.carRepository();
    private RacingGameService racingGameService = config.racingService();

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
    public void 시도횟수만큼_각Car에_랜덤정수넣기() {
        // given
        String carNames = "pobi,woni,jun";
        String tryCount = "5";
        final RacingGame racingGame = racingGameService.generateRacing(carNames, tryCount);

        // when
        racingGameService.decideRandomMoveCondition(racingGame);

        // then
        assertThat(racingGame.getTryCount()).isEqualTo(5);
    }

    @Test
    public void 단일_우승자_계산하기() {
        // given
        Car pobi = Car.create("pobi");
        pobi.addPositionByRandomNum(1);
        pobi.addPositionByRandomNum(2);

        Car woni = Car.create("woni");
        woni.addPositionByRandomNum(1);
        woni.addPositionByRandomNum(4);

        List<Car> carList = new ArrayList<>() {{
           add(pobi);
           add(woni);
        }};

        Participations participations = Participations.create(carList);

        TryCount tryCount = TryCount.create("3");
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
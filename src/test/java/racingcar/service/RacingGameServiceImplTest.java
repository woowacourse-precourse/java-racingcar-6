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

    String carNames = "pobi,woni,jun";
    String tryCount = "5";
    Car pobi = Car.create("pobi");
    Car woni = Car.create("woni");
    List<Car> carList = List.of(pobi, woni);
    RacingGame racingGame = RacingGame.create(
            Participations.create(carList),
            TryCount.create("2"),
            Winners.createEmpty());

    @BeforeEach
    public void setUp() {
        carRepository.deleteAll();
    }

    @Test
    public void 차이름과_시도횟수_정제해서_Racing객체_만들기() {
        // given

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
        final RacingGame racingGame = racingGameService.generateRacing(carNames, tryCount);

        // when
        final RacingGame result = racingGameService.save(racingGame);

        // then
        assertThat(result).isSameAs(racingGame);
    }

    @Test
    public void 시도횟수만큼_각Car에_랜덤정수넣기() {
        // given
        final RacingGame racingGame = racingGameService.generateRacing(carNames, tryCount);

        // when
        racingGameService.decideRandomMoveCondition(racingGame);

        // then
        assertThat(racingGame.getTryCount()).isEqualTo(5);
    }

    @Test
    public void 단일_우승자_계산하기() {
        // given
        pobi.addPositionByRandomNum(1);
        pobi.addPositionByRandomNum(2);

        woni.addPositionByRandomNum(1);
        woni.addPositionByRandomNum(4);

        List<Car> winnerList =  List.of(woni);

        // when
        racingGameService.calculateWinners(racingGame);

        // then
        assertThat(racingGame.calcWinnerSize()).isEqualTo(1);
        assertThat(racingGame.getWinnerList()).isEqualTo(winnerList);
    }

    @Test
    public void 공동_우승자_계산하기() {
        // given
        pobi.addPositionByRandomNum(1);
        pobi.addPositionByRandomNum(4);

        woni.addPositionByRandomNum(1);
        woni.addPositionByRandomNum(4);

        // when
        racingGameService.calculateWinners(racingGame);

        // then
        assertThat(racingGame.calcWinnerSize()).isEqualTo(2);
        assertThat(racingGame.getWinnerList()).isEqualTo(carList);
    }
}
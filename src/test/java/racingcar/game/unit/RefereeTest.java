package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest extends NsTest {

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 코스_선택() {
		assertSimpleTest(() -> {
			//given
			Referee referee = Referee.newReferee();
			String courseAttempt = "3";
			// when
			run(courseAttempt);
			Course course = referee.selectCourse();

			// then
			assertThat(output()).contains("시도할 회수는 몇회인가요?");
			assertThat(course).isNotNull();
		});
	}

	@Test
	public void 차를_보고_경기_중계() {
		assertRandomNumberInRangeTest(() -> {
					//given
					Referee referee = Referee.newReferee();
					Car firstCar = Car.of("name1");
					Car secondCar = Car.of("name2");
					// when
					firstCar.startEngine();
					secondCar.startEngine();
					firstCar.startEngine();
					secondCar.startEngine();
					referee.broadcast(
							List.of(firstCar, secondCar));
					// then
					assertThat(output()).contains(
							"name1 : --",
							"name2 : -");
				},
				MOVING_FORWARD, MOVING_FORWARD,
				MOVING_FORWARD, STOP
		);
	}

	@Test
	void 우승자_발표_한명() {
		assertRandomNumberInRangeTest(
				() -> {
					//given
					Referee referee = Referee.newReferee();
					Car firstCar = Car.of("name1");
					Car secondCar = Car.of("name2");
					// when
					firstCar.startEngine();
					secondCar.startEngine();
					firstCar.startEngine();
					secondCar.startEngine();
					referee.announceWinner(
							List.of(firstCar, secondCar));
					// then
					assertThat(output()).contains(
							"최종 우승자 : name1");
				},
				MOVING_FORWARD, MOVING_FORWARD,
				MOVING_FORWARD, STOP
		);
	}

	@Test
	void 우승자_발표_두명() {
		assertRandomNumberInRangeTest(
				() -> {
					//given
					Referee referee = Referee.newReferee();
					Car firstCar = Car.of("name1");
					Car secondCar = Car.of("name2");
					// when
					firstCar.startEngine();
					secondCar.startEngine();
					firstCar.startEngine();
					secondCar.startEngine();
					referee.announceWinner(
							List.of(firstCar, secondCar));
					// then
					assertThat(output()).contains(
							"최종 우승자 : name1");
				},
				MOVING_FORWARD, MOVING_FORWARD,
				STOP, STOP
		);
	}

	@Override
	protected void runMain() {
	}
}
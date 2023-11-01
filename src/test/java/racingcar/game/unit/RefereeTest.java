package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest extends NsTest {

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private Referee referee;
	private Car firstCar;
	private Car secondCar;

	@BeforeEach
	void setUp() {
		referee = Referee.newReferee();
		firstCar = Car.of("name1");
		secondCar = Car.of("name2");
	}

	@Test
	@DisplayName("코스 선택 후 생성 확인")
	void 코스_선택() {
		assertSimpleTest(() -> {
			//given
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
	@DisplayName("경기 중계 시 차량의 위치 출력")
	public void 차를_보고_경기_중계() {
		assertRandomNumberInRangeTest(() -> {
					//given
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
	@DisplayName("우승자 발표 시 우승자 출력")
	void 우승자_발표_한명() {
		assertRandomNumberInRangeTest(
				() -> {
					//given
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
	@DisplayName("우승자 두 명 이상 시 모두 출력")
	void 우승자_발표_두명() {
		assertRandomNumberInRangeTest(
				() -> {
					//given
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

	@Test
	@DisplayName("레이싱 경기 시작 문구 출력 확인")
	void 레이싱_경기_시작() {
		assertSimpleTest(() -> {
			// when
			referee.announceRacingStart();
			// then
			assertThat(output())
					.contains("실행 결과");
		});
	}

	@Override
	protected void runMain() {
	}
}
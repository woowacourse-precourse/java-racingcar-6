package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.message.ErrorMessage;

class CourseTest {

	private OutputStream captor;

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	void captor_설정() {
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@Test
	@DisplayName("코스 생성 시 시도 횟수가 0미만일 때 IllegalArgumentException 예외 발생")
	void 코스_생성_횟수_0미만() {
		assertSimpleTest(() -> {
			// given
			int attempt = -1;
			// when, then
			assertThatThrownBy(() -> Course.of(attempt))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining(ErrorMessage.ATTEMPT_NOT_LESS_THAN_0.getMessage());
		});
	}

	@Test
	@DisplayName("시도 횟수가 0 이상 일 때 코스 생성")
	void 코스_생성() {
		assertSimpleTest(() -> {
			// given
			int attempt = 0;
			// when
			Course course = Course.of(attempt);
			// then
			assertThat(course).isNotNull();
		});
	}


	@Test
	@DisplayName("레이싱 시작 시 심판의 중계")
	void 레이싱_시작() {
		captor_설정();
		assertRandomNumberInRangeTest(() -> {
					// given
					int attempt = 1;
					Course course = Course.of(attempt);

					String firstName = "name1";
					String secondName = "name2";
					Car firstCar = Car.of(firstName);
					Car secondCar = Car.of(secondName);

					Referee referee = Referee.newReferee();

					// when
					course.racingStart(
							List.of(firstCar, secondCar),
							referee);
					// then
					assertThat(captor.toString())
							.contains("실행 결과",
									"name1 : -", "name2 : ");
				},
				MOVING_FORWARD, STOP
		);
	}
}
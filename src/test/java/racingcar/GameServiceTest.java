package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.service.GameService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

public class GameServiceTest {
	private final GameService gameService = new GameService();

	private final MockedStatic<Randoms> randoms = mockStatic(Randoms.class);

	@AfterEach
	void afterAll() {
		randoms.close();
	}

	@Nested
	@DisplayName("going 메서드는")
	class DescribeGoing {
		private List<Car> cars;

		@BeforeEach
		void beforeEach() {
			cars = List.of(new Car("test"));
		}

		@Nested
		@DisplayName("무작위 숫자가 4 이상인 경우")
		class ContextWith4up {

			@BeforeEach
			void beforeEach() {
				given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(4);
			}

			@Test
			@DisplayName("전진한다.")
			void itReturnGo() {
				List<Car> result = gameService.going(cars);

				assertThat(result)
						.allMatch(car -> car.distance == cars.get(0).distance + 1);
			}
		}

		@Nested
		@DisplayName("무작위 숫자가 4 미만이라면")
		class ContextWith4down {
			@BeforeEach
			void beforeEach() {
				given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(3);
			}

			@Test
			@DisplayName("전진하지 않는다.")
			void itReturnWinners() {
				List<Car> result = gameService.getWinners(cars);

				assertThat(result)
						.allMatch(car -> car.distance == cars.get(0).distance);
			}
		}
	}

	@Nested
	@DisplayName("getWinners 메서드는")
	class DescribeGetWinners {
		private List<Car> cars;

		@Nested
		@DisplayName("차가 존재하는 경우")
		class ContextWithCar {
			@BeforeEach
			void beforeEach() {
				cars = List.of(new Car("test", 0), new Car("test", 1));
			}

			@Test
			@DisplayName("최장 거리를 이동한 차들을 반환한다.")
			void itReturnWinners() {
				List<Car> result = gameService.getWinners(cars);

				assertThat(result)
						.allMatch(car -> car.distance == 1);
			}
		}
	}
}
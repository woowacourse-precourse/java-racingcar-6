package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void 자동차이름리스트로_자동차객체를_생성한다() {
		List<String> carNameList = List.of("pobi","woni","jun");
		List<Car> carList = carNameList.stream()
			.map(carName -> new Car(carName))
			.collect(Collectors.toList());

		assertThat(carList).hasSize(3)
			.extracting("name", "position.position")
			.containsExactlyInAnyOrder(
				tuple("pobi",0),
				tuple("woni",0),
				tuple("jun",0)
			);
	}
}

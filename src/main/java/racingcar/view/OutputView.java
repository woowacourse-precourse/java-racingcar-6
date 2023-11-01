package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Position;
import racingcar.support.round.RoundResult;

public class OutputView {

	private OutputView() {
		throw new IllegalStateException();
	}

	public static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	public static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";
	public static final String RESULT_COMMENT = "실행 결과";
	public static final String WINNER_MESSAGE = "최종 우승자 : ";
	private static final String MOVEMENT = "-";
	private static final String ENTER = "\n";

	public static void print(String message) {
		System.out.println(message);
	}

	public static void print(List<CarName> winners) {
		List<String> winnerNames = winners.stream()
				.map(CarName::getName)
				.toList();
		print(WINNER_MESSAGE + String.join(", ", winnerNames));
	}

	public static void print(RoundResult result) {
		Map<CarName, Position> results = result.getResults();
		results.forEach(OutputView::print);
		print(ENTER);
	}

	private static void print(CarName carName, Position position) {
		print(carName.getName() + " : " + MOVEMENT.repeat(position.getPosition()));
	}
}

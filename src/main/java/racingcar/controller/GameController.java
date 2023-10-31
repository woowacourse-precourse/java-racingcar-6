package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
	private final GameService gameService;

	private final Validator validator;

	public GameController(GameService gameService, Validator validator) {
		this.gameService = gameService;
		this.validator = validator;
	}

	public void start() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String nameInput = Console.readLine();
		System.out.println("시도할 회수는 몇회인가요?");
		String countInput = Console.readLine();

		List<Car> cars = Arrays.stream(nameInput.split(","))
							   .peek(validator::validateName)
							   .map(Car::new)
							   .toList();
		validator.validateCount(countInput);
		final int count = Integer.parseInt(countInput);

		for (int i = 0; i < count; i++) {
			System.out.println("실행 결과");

			cars = gameService.going(cars);

			cars.forEach(car -> System.out.printf("%s : %s\n", car.name, "-".repeat(car.distance)));
			System.out.println();
		}

		List<Car> winners = gameService.getWinners(cars);

		System.out.printf("최종 우승자 : %s",
				winners.stream()
					   .map(car -> car.name)
					   .collect(Collectors.joining(", ")));
	}
}
package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		final var players = askName();
		final var roundCount = askRound();

		System.out.println("\n실행결과");
		var currentRound = 0;
		final var round = new Round();
		while (currentRound <= roundCount) {
			round.result(players);
			currentRound++;
		}

		int maxDistance = 0;
		for (var player : players) {
			final var distance = player.distance();
			if (maxDistance < distance) {
				maxDistance = distance;
			}
		}

		final var winners = new StringBuilder();
		for (final var player : players) {
			final var distance = player.distance();
			if (distance == maxDistance) {
				final var name = player.name();
				winners.append(name).append(", ");
			}
		}

		final String result = winners.substring(0, winners.length() - 2);
		System.out.println("최종 우승자 : " + result);
	}

	private static List<Car> askName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		final var names = Console.readLine();
		return Converter.stringToCarList(names);
	}

	public static int askRound() {
		System.out.println("시도할 회수는 몇회인가요?");
		final var roundCountInput = Console.readLine();
		return Converter.stringToInteger(roundCountInput);
	}
}

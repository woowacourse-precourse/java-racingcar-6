package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Umpire {
	public String decideTheWinners(String[] cars, List<StringBuilder> steps) {
		int stepMax = stepMax(steps);
		List<String> winners = findWinners(cars, steps, stepMax);
		return winnersToString(winners);
	}

	private int stepMax(List<StringBuilder> steps) {
		int stepMax = 0;
		for (int i = 0; i < steps.size(); i++) {
			stepMax = Math.max(stepMax, steps.get(i).length());
		}
		return stepMax;
	}

	private List<String> findWinners(String[] cars, List<StringBuilder> steps, int stepMax) {
		List<String> winners = new ArrayList<>();
		for (int i = 0; i < steps.size(); i++) {
			if (steps.get(i).length() == stepMax) {
				winners.add(cars[i]);
			}
		}
		return winners;
	}

	private String winnersToString(List<String> winners) {
		StringBuilder announcement = new StringBuilder();

		for (int i = 0; i < winners.size(); i++) {
			announcement.append(winners.get(i));
			announcement.append(", ");
		}
		announcement.deleteCharAt(announcement.length()-1);
		announcement.deleteCharAt(announcement.length()-1);

		return announcement.toString();
	}
}

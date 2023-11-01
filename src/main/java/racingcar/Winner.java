package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
	CarMoving CarMoving = new CarMoving();

	public void PrintWinnerList(List<Integer> BarCount, List<String> CarName) {
		List<Integer> Winner = BarCount;
		List<String> WinnerList = WinnerSelect(CarName, Winner);
		System.out.println("최종 우승자 : " + WinnerList.stream().collect(Collectors.joining(",")));
	}

	private int Max(List<Integer> Winner) {
		return Winner.stream().mapToInt(x -> x).max().getAsInt();
	}

	private List<String> WinnerSelect(List<String> CarName, List<Integer> Winner) {
		List<String> WinnerList = new ArrayList<>();
		int CarNameCount = CarMoving.CarNameCount(CarName);
		int Max = Max(Winner);
		int i = 0;

		while (i < CarNameCount) {
			if (Winner.get(i) == Max) {
				WinnerList.add(CarName.get(i));
			}
			i++;
		}

		return WinnerList;
	}
}

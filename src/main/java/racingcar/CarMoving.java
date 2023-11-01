package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarMoving {

	Computer ComputerClass = new Computer();

	public List<Integer> CarMovingPrint(List<String> CarName, Integer TryCount) {
		int i = 0;
		List<Integer> BarCountList = initializeBarCountList(CarName);

		while (i < TryCount) {
			CarPositionPrint(CarName, BarCountList);
			i++;
		}

		return BarCountList;
	}

	private void CarPositionPrint(List<String> CarName, List<Integer> BarCountList) {
		int i = 0;
		int CarNameCount = CarNameCount(CarName);
		List<Integer> Bar = BarCountList(CarNameCount, BarCountList);

		while (i < CarNameCount) {

			System.out.print(CarName.get(i) + " : ");
			PrintBar(Bar.get(i));
			System.out.println();
			i++;
		}
		System.out.println();

	}

	private void PrintBar(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print("-");
		}
	}

	private List<Integer> BarCountList(int CarNameCount, List<Integer> BarCountList) {
		int i = 0;

		while (i < CarNameCount) {
			int count = BarCountList.get(i) + 1;
			if (ComputerClass.RandomComputerNum() >= 4) {
				BarCountList.set(i, count);
			}
			i++;
		}

		return BarCountList;
	}

	public int CarNameCount(List<String> CarName) {
		int CarNameCountInt = CarName.size();
		return CarNameCountInt;
	}

	private List<Integer> initializeBarCountList(List<String> carNames) {
		return IntStream.range(0, carNames.size()).mapToObj(i -> 0).collect(Collectors.toList());
	}

}

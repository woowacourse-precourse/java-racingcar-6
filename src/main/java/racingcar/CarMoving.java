package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarMoving {

	public List<String> CarMoving(List<String> CarName, Integer MovingCount) {
		int i = 0;
		List<String> PrintBar = new ArrayList<>();

		while (i < CarNameCountLong(CarName)) {
			String MovingBarStr = MovingBar(MovingCount);
			PrintBar.add(CarName.get(i) + " : " + MovingBarStr);
			i++;
		}

		return PrintBar;
	}

	private Integer CarNameCountLong(List<String> CarName) {
		Long CarNameCountLong = CarName.stream().collect(Collectors.counting());
		int CarNameCountInt = CarNameCountLong.intValue();
		return CarNameCountInt;
	}

	private String MovingBar(Integer MovingCount) {
		List<String> BarList = new ArrayList<>();
		int j = 0;

		while (j != MovingCount) {
			int ComputerRandomNum = RandomNum();
			if (ComputerRandomNum >= 4) {
				BarList.add("-");
			}
			j++;
		}

		return ListToStr(BarList);
	}

	private Integer RandomNum() {
		Computer ComputerClass = new Computer();
		int RandomNum = ComputerClass.RandomComputerNum();

		return RandomNum;
	}

	private String ListToStr(List<String> list) {
		String strValue = list.stream().map(String::valueOf).collect(Collectors.joining());
		return strValue;
	}
}

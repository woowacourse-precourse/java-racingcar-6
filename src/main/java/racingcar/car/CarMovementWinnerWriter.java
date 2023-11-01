package racingcar.car;

import java.util.List;

public class CarMovementWinnerWriter {

	RacingCarWinnerFinder racingCarWinner = new RacingCarWinnerFinder();
	private static final Integer startingIndex = 0;
	private static final Integer startSubString = 0;
	private static final Integer endSubString = 2;
	private static final String EmptyInitialString = "";
	private static final String WinnerDividePoint = ", ";
	private static final String WinnerSign = "최종 우승자 : ";

	public void writeCarMovementWinner(List<Car> carList,
		CarMovementResultLogStorage carMovementResultLogStorage) {
		List<String> racingCarWinnerStringList = racingCarWinner.getRacingCarWinner(carList,
			startingIndex);
		String racingCarWinnerString = EmptyInitialString;
		for (String racingCarWinner : racingCarWinnerStringList) {
			racingCarWinnerString = racingCarWinnerString + racingCarWinner + WinnerDividePoint;
		}
		Integer endSubString = racingCarWinnerString.length() - endSubStringPoint;
		String racingCarWinnerFinalString = racingCarWinnerString.substring(startSubString,
			endSubString);
		carMovementResultLogStorage.addLog(WinnerSign + racingCarWinnerFinalString);
	}
}

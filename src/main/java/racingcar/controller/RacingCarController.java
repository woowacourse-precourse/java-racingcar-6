package racingcar.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.dto.request.CarNameReq;
import racingcar.dto.request.TryNumberReq;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarController {

	CarNameReq carNameReq = new CarNameReq();
	TryNumberReq tryNumberReq = new TryNumberReq();

	public void saveCarName() {
		System.out.println("차 이름 입력 테스트");
		carNameReq.setCarName(readLine());
		validateCarName(carNameReq.getCarName());
		System.out.println(carNameReq.getCarName()+"성공");
	}

	public void saveTryNumber() {
		System.out.println("시도 입력 테스트");
		tryNumberReq.setTryNumber(readLine());
		validateTryNumber(tryNumberReq.getTryNumber());
		System.out.println(tryNumberReq.getTryNumber()+"성공");
	}

	private static void validateTryNumber(String tryNumber) {
		if (tryNumber.isEmpty()) {
			throw new IllegalArgumentException("값을 입력하세요.");
		}
		checkTryNumberIsNumber(tryNumber);
	}

	private static void checkTryNumberIsNumber(String tryNumber) {
		if (tryNumber.matches("^\\d+$")) {
			int tryNumberInt = Integer.parseInt(tryNumber);

			checkTryNumberIsPositive(tryNumberInt);
		} else {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}

	private static void checkTryNumberIsPositive(int tryNumberInt) {
		if (tryNumberInt <= 0) {
			throw new IllegalArgumentException("입력값은 0보다 커야 합니다.");
		}
	}

	public static void validateCarName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException("입력이 비어 있습니다.");
		}

		String[] names = carName.split(",");
		for (String name : names) {
			checkLengthAndSpace(name);
		}
	}

	private static void checkLengthAndSpace(String name) {
		if (name.isEmpty() || name.length() > 5 || containsWhitespace(name)) {
			throw new IllegalArgumentException("유효하지 않은 이름이 포함되어 있습니다.");
		}
	}

	public static boolean containsWhitespace(String s) {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(s);
		return matcher.find();
	}

}

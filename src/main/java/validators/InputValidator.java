package validators;

public class InputValidator {
	
	private static final String NULL_ERROR = "입력값이 비어있습니다.";
	private static final String CARNAME_LENGHT_ERROR = "자동차 이름은 5글자 이하로 지정해주세요.";
	private static final String CARMOVE_ZERO_ERROR = "이동횟수는 0 이상을 지정해주세요.";
	private static final String INVALID_VALUE = "입력값을 잘못 입력하셨습니다.";
	
	public static void checkCarName(String carName) {
		if(carName.length() > 5) {
			throw new IllegalArgumentException(CARNAME_LENGHT_ERROR);
		}
	}
	
	public static void checkNull(String input) {
		if(input.isBlank()) {
			throw new IllegalArgumentException(NULL_ERROR);
		}
	}
	
	public static void checkCarMoveFomat(String inputTotalMove) {
		if(!inputTotalMove.matches("[0-9]+")) {
			throw new IllegalArgumentException(INVALID_VALUE);
		}
	}
	
	public static void checkCarMove(int totalMove) {
		if(totalMove == 0) {
			throw new IllegalArgumentException(CARMOVE_ZERO_ERROR);
		}
	}
}

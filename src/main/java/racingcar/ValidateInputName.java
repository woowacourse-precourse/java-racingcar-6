package racingcar;

public class ValidateInputName {
	public static void validateNameLenth(String carName) {
		if(carName.length() > 5) {
			System.out.println("자동차 이름의 최대 길이는 5입니다.");
			throw new IllegalArgumentException(); 
		}
	}
}

package racingcar.View;

public class InputValidator {
	static public void validateCarNamesInput(String input){
		if(!input.contains(",")){
			throw new IllegalArgumentException("이름은 쉼표(,)로 구분해야 합니다.");
		}
		String[] carsArray = input.split(",");
		for(String car : carsArray){
			if(car.length() > 5){
				throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
			}
		}
	}

	static public void validateRoundCountInput(String input){
		if(!input.matches("\\d+")){
			throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
		}
		if (input.matches("0")) {
			throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자로 입력해야 합니다.");
		}
	}
}

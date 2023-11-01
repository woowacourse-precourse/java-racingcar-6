package Carset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import validation.Validation;

public class CarNamedSet {
	private List<String> CarNamed;
	private Validation validation;

	public CarNamedSet() { // 이름 세팅 생성자
		validation = new Validation();
		CarSetting();

	}

	public List<String> NameSetting() { // 이름을 입력하기 위한 메서드
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String members = Console.readLine();
		validateAndSetCarNames(members);
		CarNamed = Arrays.asList(members.split(","));

		return CarNamed;
	}

	private void validateAndSetCarNames(String input) {// validation 하기 위한 메서드
		validation.validateCarNamesFormat(input);
		CarNamed = Arrays.asList(input.split(","));
	}

	public void CarSetting() {//List 생성 함수
		CarNamed = new ArrayList<>();
	}



}

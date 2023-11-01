package controller;

import camp.nextstep.edu.missionutils.Console;

import static data.Constants.VERIFICATION;

public class InputValues {
	
	//private static final exceptions.EncounterExceptions VERIFICATION=new EncounterExceptions();
	
	public String [] provideNames() {
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String names=Console.readLine();
		names=removeSpace(names);
		
		String [] eachName=VERIFICATION.nameInspection(names);
		
		return eachName;
	}
	
	public String removeSpace(String input) {
		
		String output=input.replace(" ", "");

		return output;
	}
	
	public int provideRoundCount() {
		
		System.out.println("시도할 회수는 몇회인가요?");
		String inputCount=Console.readLine();
		inputCount=removeSpace(inputCount);
		
		int roundCount=VERIFICATION.countInspection(inputCount);
		
		return roundCount;
	}
}

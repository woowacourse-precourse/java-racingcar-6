package Controller;

import Exceptions.EncounterExceptions;
import camp.nextstep.edu.missionutils.Console;

public class InputValues {
	
	private final Exceptions.EncounterExceptions verification=new EncounterExceptions();

	public String [] provideNames() {
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String names=Console.readLine();
		
		String [] eachName=verification.nameInspection(names);
		
		return eachName;
	}
	
	public int provideRoundCount() {
		
		System.out.println("시도할 회수는 몇회인가요?");
		String inputCount=Console.readLine();
		
		int roundCount=verification.countInspection(inputCount);
		
		return roundCount;
	}
}

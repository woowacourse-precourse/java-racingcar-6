package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

	private String [] names;
	private int count;
	
	
	public void Input() {
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String input = Console.readLine();

		names = input.split(",");
		
		System.out.println("시도할 회수는 몇회인가요?");
		
		String cntstr = Console.readLine();
		
		count = Integer.parseInt(cntstr);
		
		
	}

	public String [] getNames() {
		return names;
		
	}
	public int getCount() {
		return count;
	}
	
}

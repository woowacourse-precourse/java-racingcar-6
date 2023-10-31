package racingcar;

import camp.nextstep.edu.missionutils.Console;

class car {
	String name;
	String GoCount = "";
	int RanNum;

	public void move() {
		if (RanNum >= 4) {
			GoCount += "-";
		}
	}
}

public class Application {
    public static void main(String[] args) {
		System.out.println("자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String Input_Name = Console.readLine();
		System.out.println("시도할 회수는 몇회인가요?");
		String Input_Trynum = Console.readLine();
		String[] arr_Name = Input_Name.split(",");
		int TryNum = Integer.parseInt(Input_Trynum);
		car[] members = new car[arr_Name.length];
		System.out.println("실행 결과");
    }
}

package racingcar;

import setting.Information;

public class Application {
	public static void main(String[] args) {
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Information inf = new Information();
		inf.inputname();

		System.out.println("시도할 회수는 몇회인가요?");
		inf.inputNum();

		System.out.print("최종 우승자 : ");
		inf.winner();
	}
}

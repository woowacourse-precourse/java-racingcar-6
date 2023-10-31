package racingcar;

public class RacingCarService {

	private RegistCarInfo registCarInfo;

	public String playRacing() {
		System.out.println("경주할 자동차 이름을 입력하세요. " +
				"(이름은 쉼표(,) 기준으로 구분)");
		registCarInfo.registCarName(Console.readLine());


		return null;
	}
}

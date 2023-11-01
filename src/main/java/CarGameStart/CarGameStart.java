package CarGameStart;

import java.util.List;

import Carset.Car;
import Carset.CarNamedSet;
import Carset.PrintResult;

public class CarGameStart {
	private CarNamedSet nameset;
	private PrintResult result;
	private List<String> carNameds;

	public CarGameStart() { //Game을 시작하는 생성자
		nameset = new CarNamedSet();
		carNameds = nameset.NameSetting();
		result = new PrintResult(carNameds);

	}

	public void run() {//전반적인 게임을 시작과 출력을 함
		result.printStatus();

	}

}

package racingcar;

import racingcar.domain.Input;
import racingcar.domain.CarContainer;
import racingcar.domain.CarManager;
import racingcar.domain.CarState;
import racingcar.domain.GameCount;
import racingcar.domain.GameManager;

public class Application {
	public static void main(String[] args) {

		CarContainer CarContainer = new CarContainer();
		Input CalssInput = new Input();
		GameCount GameCount = new GameCount();
		GameManager GameManager = new GameManager();

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		CarContainer.setcontainer(CalssInput.readLine());

		CarState CarState = new CarState(CarContainer.Get_CarContainer().size());
		CarManager CarManager = new CarManager(CarContainer.Get_CarContainer().size());

		System.out.println("시도할 회수는 몇회인가요?");
		GameCount.setGameCount();
		int iGameCount = 0;

		System.out.println("실행 결과");
		while (iGameCount < GameCount.getGameCount()) {

			CarManager.setiCarRandomState();
			CarState.set_iCarStateList(CarManager.getiCarRandomState());

			GameManager.viewGmae(CarContainer.Get_CarContainer(), CarState.get_iCarStateList());
			++iGameCount;
		}
		GameManager.viewGameResult(CarContainer.Get_CarContainer(), CarState.get_iCarStateList());
	}
}

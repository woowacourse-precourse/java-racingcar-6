package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarService;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class GameController {
    private UserInput userInput = new UserInput();
    private CarService carService = new CarService();
    private Output output;

    private List<Car> carList;
    private int gameCount;

    //전체 게임 횟수만큼 게임 반복 및 실행 start 기능
    public void gameStart() {
        askInputUser();

        //자동차 객체 임시 컨트롤
        for (int i = 0; i < gameCount; i++) {
            for (int j = 0; j < carList.size(); j++) {
                //전진, 멈춤 판별
                boolean flag = carService.judgeRunOrStop();
                //판별된 상태에 따른 상태 세팅
                carService.setCurrentCar(flag, carList.get(j));
            }
            output = new Output(carService);
            //(1) 출력 : 현재의 게임 객체들 상태 출력
            output.printCurrentCar(carList);
        }
        //(2) 출력 : 최종 우승자 출력
        output.printFinalWinner(carList);
    }

    //1) 사용자 입력 처리해서 객체에도 세팅
    private void askInputUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carList = changeUserInputToCarList(userInput.readCarNames());

        System.out.println("시도할 회수는 몇회인가요?");
        gameCount = userInput.readGameCount();
    }

    //1) 입력받은 자동차 이름별 Car 클래스 생성 및 리스트에 담기
    private List<Car> changeUserInputToCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }
}
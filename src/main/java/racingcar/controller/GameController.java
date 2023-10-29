package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.CarService;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class GameController {
    UserInput userInput;
    CarService carService;
    Output output;

    public GameController() {
        userInput = new UserInput();


    }

    //전체 게임 횟수만큼 게임 반복 및 실행 start 기능
    public void gameStart() {
        askInputUser(userInput);

        carService = new CarService(userInput);

        int count = carService.input.getGameCount();
        ArrayList<Car> carsList = carService.carList;
        //자동차 객체 임시 컨트롤
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carsList.size(); j++) {
                //전진, 멈춤 판별
                boolean flag = carService.judgeRunOrStop();
                //판별된 상태에 따른 상태 세팅
                carService.setCurrentCar(flag, carsList.get(j));
            }
            output = new Output(carService);
            //(1) 출력 : 현재의 게임 객체들 상태 출력
            output.printCurrentCar(carsList);
        }
        //(2) 출력 : 최종 우승자 출력
        output.printFinalWinner(carsList);
    }

    //1) 사용자 입력 처리해서 객체에도 세팅
    public void askInputUser(UserInput userInput) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        
        userInput.validateInput(carName);

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());

        userInput.setUserInputCarName(carName);
        userInput.setGameCount(gameCount);
    }


}
package racingcar.controller;

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
        userInput.inputUser(userInput);//입력받고
        carService = new CarService(userInput);
    }

    //전체 게임 횟수만큼 게임 반복 및 실행 start 기능
    public void gameStart() {
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
}
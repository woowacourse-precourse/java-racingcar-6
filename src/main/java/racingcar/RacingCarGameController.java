package racingcar;

import domain.Cars;
import service.UserInputCarNameFactory;
import ui.Input;

public class RacingCarGameController {

    private UserInputCarNameFactory userInputCarNameFactory;

    public RacingCarGameController(UserInputCarNameFactory userInputCarNameFactory){
        this.userInputCarNameFactory = userInputCarNameFactory;
    }
    public void play(){

        //1. 차 이름사용자 입력
        Input.carNameReadLine();

        //2. Cars 객체 생성
        Cars cars = userInputCarNameFactory.createCars();

        //3. 이동 횟수 사용자 입력

        //4. 자동차 전진

        //5. 우승자 판별

        //6. 우승자 출력
    }
}

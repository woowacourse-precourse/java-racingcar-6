package racingcar;

import com.sun.jdi.InvalidTypeException;
import domain.Car;
import domain.Cars;
import dto.UserInputCarMoveCountDto;
import service.CarMoveService;
import service.CarRacingWinnerService;
import service.UserInputCarMoveCountFactory;
import service.UserInputCarNameFactory;
import ui.Input;
import ui.Output;
import util.BeanFactory;

import java.util.List;

public class RacingCarGameController {

    private final UserInputCarNameFactory userInputCarNameFactory;
    private final UserInputCarMoveCountFactory userInputCarMoveCountFactory;
    private final CarMoveService carMoveService;
    private final CarRacingWinnerService carRacingWinnerService;

    public RacingCarGameController(){

        this.userInputCarNameFactory = BeanFactory.getInstanceUserInputCarNameFactory();
        this.userInputCarMoveCountFactory = BeanFactory.getInstanceUserInputCarMoveCountFactory();
        this.carMoveService = BeanFactory.getInstanceCarMoveService();
        this.carRacingWinnerService = BeanFactory.getInstanceCarRacingWinnerService();
    }
    public void play() throws InvalidTypeException {

        //1. 차 이름사용자 입력
        Input.carNameReadLine();

        //2. Cars 객체 생성
        Cars cars = userInputCarNameFactory.createCars();

        //3. 이동 횟수 사용자 입력
        Input.carMoveCountReadLine();

        //4. 이동 횟수 유효성 검증 및 이동 객체 생성
        UserInputCarMoveCountDto userInputCarMoveCountDto = userInputCarMoveCountFactory.createUserInputCarMoveCountDto();

        //5. 출력 객체 초기화
        Output.init();

        //6. 자동차 전진
        carMoveService.move(cars,userInputCarMoveCountDto);

        //7. 우승자 판별
        carRacingWinnerService.selectWinnerWithOutput(cars);

        //8. 출력
        Output.printResult();
    }
}

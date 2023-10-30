package racingcar;

import com.sun.jdi.InvalidTypeException;
import domain.Cars;
import dto.UserInputCarMoveCountDto;
import service.CarMoveService;
import service.CarRacingWinnerService;
import service.UserInputCarMoveCountFactory;
import service.UserInputCarNameFactory;
import ui.Input;

public class RacingCarGameController {

    private UserInputCarNameFactory userInputCarNameFactory;
    private UserInputCarMoveCountFactory userInputCarMoveCountFactory;
    private CarMoveService carMoveService;
    private CarRacingWinnerService carRacingWinnerService;

    public RacingCarGameController(UserInputCarNameFactory userInputCarNameFactory,
                                   UserInputCarMoveCountFactory userInputCarMoveCountFactory,
                                   CarMoveService carMoveService,
                                   CarRacingWinnerService carRacingWinnerService){
        this.userInputCarNameFactory = userInputCarNameFactory;
        this.userInputCarMoveCountFactory = userInputCarMoveCountFactory;
        this.carMoveService = carMoveService;
        this.carRacingWinnerService = carRacingWinnerService;
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

        //5. 자동차 전진
        carMoveService.move(cars,userInputCarMoveCountDto);

        //6. 우승자 판별
        carRacingWinnerService.selectWinner(cars);

        //7. 우승자 출력

    }
}

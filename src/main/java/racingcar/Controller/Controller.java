package racingcar.Controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.Function.Function;
import racingcar.util.InputPoint;
import racingcar.util.Validate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final Function function = new Function();
    private final InputPoint inputPoint = new InputPoint();
    private final Validate validate = new Validate();
    private final CarRepository carRepository = new CarRepository();
    //최초 실행
    public void run() {
        saveCars(inputPoint.inputCarNames(getCarName()));
        play(createGame());
    }
    //게임 생성
    private Game createGame() {
        Game game = new Game(getCar_List(), getTrial_Number());
        function.save(game);
        return game;
    }
    //생성된 게임 실행
    private void play(Game game) {
        OutputView.printHead();
        while (!function.isEnd(game)) {
            function.play(game);
            OutputView.printScore(game.getCars());
        }
        OutputView.printWinners(function.getWinners(game));
    }
    //자동차 이름 입력
    private String getCarName() {
        InputView.requestCarName_Message();
        String input = Console.readLine();
        return validateInput_CarName(input);
    }
    //입력 받은 자동차 이름 검사
    private String validateInput_CarName(String input) {
        try {
            validate.checkInput_CarName(input);
            return input;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
    //자동차 이름 저장
    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }
    //저장된 자동차 데이터 가져 오기
    private List<Car> getCar_List() {
        return carRepository.all_Cars();
    }
    //시행 횟수 동작
    private int getTrial_Number() {
        return inputPoint.inputTrial_Number(getTrial_UserInput());
    }
    //시행 횟수 입력
    private String getTrial_UserInput() {
        InputView.requestTrialNumber_Message();
        return validateInput_TrialNumber(Console.readLine());
    }
    //입력 받은 시행 횟수 검사
    private String validateInput_TrialNumber(String input) {
        try {
            validate.checkInput_TrialNumber(input);
            return input;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
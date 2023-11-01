package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.TypeConverter;
import racingcar.service.Validator;
import racingcar.view.Views;
import racingcar.service.GameService;
import racingcar.domain.Cars;
import racingcar.domain.Car;

import java.util.List;

public class Controller {
    private Views view = new Views();
    private GameService service = new GameService();
    private Cars cars = new Cars();
    private Validator validator = new Validator();
    private TypeConverter typeConverter = new TypeConverter();
    private final int FIRST_LOCATION = 0;

    public void makeGame(){
        startGame();
        progressGame(makeTrialNumber(),cars.getCars());
        endGame();
    }
    public void startGame(){
        makeCars();
    }

    public void progressGame(int trialNum, List<Car> carList){
        view.printResultMessage();
        for(int i=0; i < trialNum; i++){
            service.moveRandomNumber(carList);
            printRoundResult(carList);
            view.printLineBreak();
        }
    }
    public void endGame(){
        view.printLastWinnerMessage();
        view.printWinner(service.calcWinner(cars.getCars()));
    }
    public void printRoundResult(List<Car> carList){
        for(Car car : carList){
            view.printCarName(car);
            view.printLocation(car);
            view.printLineBreak();
        }
    }
    public void makeCars(){
        view.printInputCarMessage();
        String carName = getCarNames();
        List<String>carList = service.splitCarNames(carName);
        validator.validateCarNames(carList);
        makeCarList(carList);
    }
    public int makeTrialNumber(){
        view.printInputTrialMessage();
        return getTrialNumber();
    }
    public String getCarNames(){
        String input = Console.readLine();
        return input;
    }
    public int getTrialNumber(){
        String input = Console.readLine();
        validator.validateTrialNumber(input);
        return typeConverter.stringToInt(input);
    }
    public void makeCarList(List<String> input){
        for(String name : input){
            cars.saveCars(new Car(name,FIRST_LOCATION));
        }
    }


}

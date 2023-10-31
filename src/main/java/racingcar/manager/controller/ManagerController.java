package racingcar.manager.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.manager.model.Car;
import racingcar.manager.view.ManagerView;

public class ManagerController {

    private static int START_NUMBER_RANGE = 0;
    private static int END_NUMBER_RANGE = 9;
    private static int ZERO_MOVE = 0;
    private final ManagerView managerView = new ManagerView();
    private final CarController carController = new CarController();
    private final UserController userController = new UserController();


    public void run(){
        List<Car> cars = carController.getCars();
        Integer tryCount = userController.getUserTryCount();

        resultExecutionMessage();
        executeRacing(cars,tryCount);
        List<String> winnerCars = judgeWinnerCar(cars);
        finalWinner(winnerCars);
    }
    public int createRandomNumber(){
        return Randoms.pickNumberInRange(START_NUMBER_RANGE, END_NUMBER_RANGE);
    }

    public void executeRacing(List<Car> cars, Integer tryCount){
        for(int i=0;i<tryCount;i++) {
            executeOneTry(cars);
            printTryResult(cars);
            finishOneTry();
        }
    }
    public void executeOneTry(List<Car> cars){
        for(Car car: cars){
            car.moveOrStop(createRandomNumber());
        }
    }
    public void resultExecutionMessage(){
        managerView.printResultMessage();
    }
    public void finishOneTry(){
        managerView.printFinishOneTry();
    }

    public void printTryResult(List<Car> cars){
        for(Car car:cars){
            String carName = car.getCarName();
            Integer moveCount = car.getMoveCount();

            String totalMoveCount = managerView.getTotalMoveCount(moveCount);
            managerView.printMovingMessage(carName,totalMoveCount);
        }
    }

    public List<String> judgeWinnerCar(List<Car> cars){
        int maxMove = ZERO_MOVE;
        List<String> winnerCars = new ArrayList<>();
        for(Car car:cars){
            if(car.getMoveCount()>maxMove){
                maxMove = car.getMoveCount();
                winnerCars.clear();
                winnerCars.add(car.getCarName());
            }
            else if(car.getMoveCount()==maxMove){
                winnerCars.add(car.getCarName());
            }
        }
        return winnerCars;
    }

    public void finalWinner(List<String> winnerCars){
        managerView.printFinalWinners(winnerCars);
    }






}

package controller;

import domain.Car;
import service.CarService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GeneralController {

    CarService carService;
    public GeneralController(){
        carService = new CarService();
    }
    
    public void gameStart(){
        carService.saveCars(InputView.splitNames(inputCarName()));
        int numOfTry = InputView.numberOfTry(inputTryValue());

        System.out.println("\n" + OutputView.RESULT_START_MESSAGE);

        racing(numOfTry);

        System.out.print(OutputView.RESULT_WINNER_MESSAGE);

        outputWinner();
    }

    private void outputWinner() {
        carService.updateWinner();

        boolean first = true;
        for(Car winner : carService.getWinner()){
          String addBlankOrComma= ", ";
          if(first){
              addBlankOrComma = " ";
              first = false;
          }
            System.out.println(addBlankOrComma+winner.getName());
        }

    }

    public String inputCarName(){
        System.out.println(InputView.INPUT_CARNAME_MESSAGE);
        return InputView.getInput();
    }
    public String inputTryValue(){
        System.out.println(InputView.INPUT_NUMBEROFTRY_MESSAGE);
        return InputView.getInput();
    }
    public void racing(int numOfTry){
        List<Car> cars = carService.findCars();

        for(int i=0; i< numOfTry; i++){
            List<Integer> randomNumberList = new ArrayList<>(carService.repositorySize());

            fillListWithRandomValue(randomNumberList, carService.repositorySize());

            carService.moveAllCars(randomNumberList);

            System.out.println(OutputView.middleResult(cars));
        }
    }

    private void fillListWithRandomValue(List<Integer> randomNumberList,int size) {
        for(int j = 0; j< size; j++){
            int randomValue = InputView.makeRandomValues();
            randomNumberList.add(randomValue);
        }
    }


}

package racingcar.domain;

import racingcar.message.GameMessage;
import racingcar.util.CarGenerator;
import racingcar.util.RacingSimulator;
import racingcar.view.OutputView;
import racingcar.view.Inputview;

import java.util.List;

public class RacingGame {

    public void start(){
        printRequestNames();
        List <Car> cars = generateCars();
        printRequestNumber();
        RacingSimulator simulator = new RacingSimulator(Integer.parseInt(Inputview.consoleLine()));
        System.out.println();
        printStartResult();

        while(simulator.checkZero()){
            simulator.playSimulator(cars);
            printSimulationResult(cars);
        }

            System.out.println();




    }

    private void printRequestNames(){
        OutputView.consoleLine(GameMessage.INSERT_NAME_MESSAGE);
    }

    private void printRequestNumber(){
        OutputView.consoleLine(GameMessage.INSERT_TURN_MESSAGE);
    }

    private void printStartResult() {OutputView.consoleLine(GameMessage.INSERT_RESULT_MESSAGE);}

    private List<Car> generateCars(){
        CarGenerator carGenerator = new CarGenerator(Inputview.consoleLine());
        carGenerator.splitNames();
        return carGenerator.generateCars();
    }

    private void printSimulationResult(List<Car> cars){
        for(Car car : cars){
            car.printResult();
        }
        System.out.println();
    }





}

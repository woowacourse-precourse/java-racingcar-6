package racingcar;

import java.util.List;

public class RacingCarPlayer implements GamePlayer{
    List<String> carNames;
    Integer numberOfCars;
    Integer numberOfRounds;
    Configurations configurations;
    AdvancingMachine advancingMachine;
    Scanner scanner;
    Printer printer;
    RandomNumbersGenerator randomNumbersGenerator;


    @Override
    public void run() {

    }
    RacingCarPlayer(){
        configurations = new Configurations();
        advancingMachine = new AdvancingMachine(configurations.getControlValue(),configurations.getMovingDistance());
        scanner = new Scanner(configurations);
        printer = new Printer();
    }

}

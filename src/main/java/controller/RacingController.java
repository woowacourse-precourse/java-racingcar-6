package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Car;
import model.Race;
import model.RacingCar;
import validate.Validator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingController {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void init(){
        inputView.createCar();
        ArrayList<Car> carArrayList = Stream
                .of(Console.readLine().split(","))
                .map(name -> new RacingCar(Validator.checkName(name)))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        inputView.inputLaps();
        int laps = Validator.checkNum(Console.readLine());

        Race race = new Race(laps, carArrayList);
        startRace(race);
        endRace(race);
    }

    public static void startRace(Race race){
        outputView.printResult();
        for(int i =0; i<race.getLaps();i++){
            race.startDrive();
            race.getCarArrayList().forEach(car -> outputView.printPosition(car));
            outputView.printLine();
        }
    }

    public static void endRace(Race race){
        ArrayList<String> winner = race.CheckWinner();
        outputView.printWinner(winner);
    }
}

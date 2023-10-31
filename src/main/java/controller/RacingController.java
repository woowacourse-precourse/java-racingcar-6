package controller;

import model.Car;
import model.Race;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class RacingController {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void init(){
        ArrayList<Car> carArrayList = inputView.createCar();
        int laps = inputView.setLaps();
        Race race = new Race(laps, carArrayList);
        startRace(race);
    }

    public static void startRace(Race race){
        outputView.printResult();
        for(int i =0; i<race.getLaps();i++){
            race.startDrive();
            race.getCarArrayList().forEach(car -> outputView.printPosition(car));
        }
    }
}

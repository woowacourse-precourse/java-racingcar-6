package controller;

import domain.Car;
import domain.Cars;
import view.InputView;

import java.util.List;

public class FrontController {
    private final CarController carController;
    private final InputView inputView;
    private final Cars cars;

    public FrontController(CarController carController, InputView inputView, Cars cars){
        this.carController = carController;
        this.inputView = inputView;
        this.cars = cars;
    }

    public void run(){
        final Cars cars = readyCars();
        processCarRace(cars);
    }

    private Cars readyCars(){
        return carController.createCars(inputView.readCarNames());
    }

    private void processCarRace(Cars carList){
        int totalAttempts = inputView.readAttempts();
        
    }
}

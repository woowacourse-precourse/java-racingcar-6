package service;

import controller.RandomNumber;
import input.Input;
import model.CarList;
import output.OutputView;

import java.util.List;

public class RacingModule {
    Input input;
    OutputView outputView;
    CarList carList;
    RandomNumber randomNumber;
    public RacingModule() {
        input = new Input();
        outputView = new OutputView();
        carList = new CarList();
        randomNumber = new RandomNumber();
    }

    public void game(){
        outputView.printInputMsg();
        carList.setCarList(input.readCarName());
        outputView.printTryNumMsg();
        int tryNum = input.readTryNum();



    }
}

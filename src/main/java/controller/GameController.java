package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import util.ReformatHandler;
import view.InputView;

public class GameController {

    ArrayList<Car> carList = new ArrayList<>();
    int gameTimes = 0;

    public void startGame() {
        String nameListString = InputView.enterCarNames();
        List<String> nameList = ReformatHandler.nameListDivider(nameListString);
        for (String name : nameList) {
            this.carList.add(new Car(name));
        }
    }

}

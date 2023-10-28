package controller;

import java.util.ArrayList;
import model.Car;
import view.Input_view;
import view.Output_view;

public class Racing_game {
    private final Input_view inputView = new Input_view();
    private ArrayList<Car> carList = null;
    private int matches_count = 0;

    public Racing_game(){
        Output_view.GameStart();
        if(!setting_car_name()) return;
    }
    public boolean setting_car_name(){
        carList = new ArrayList<Car>();
        String[] car_names = inputView.getInput("text").split(",");
        for (String name : car_names) {
            if(name.length() > 5) {
                Output_view.Error();
                return false;
            }
            else{
                this.carList.add(new Car(name));
            }

        }
        return true;
    }
}

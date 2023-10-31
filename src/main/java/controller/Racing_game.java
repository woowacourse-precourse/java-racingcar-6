package controller;

import camp.nextstep.edu.missionutils.Randoms;
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
        setting_game_matches();
        racing_start();
        game_finish();

    }
    public boolean setting_car_name(){
        carList = new ArrayList<>();
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
    public void setting_game_matches(){
        Output_view.NumberOfGameMatches();
        this.matches_count = Integer.parseInt(inputView.getInput("number"));
    }
    public void racing_start(){
        Output_view.CarDeprture();
        for(int i = 0; i < this.matches_count; i++) {
            for (Car car : carList){
                move_car(car);
            }
            Output_view.new_line();
        }
    }
    public void move_car(Car car){
        if(Randoms.pickNumberInRange(0,9) >= 4){car.setCarState(car.getCarState() + 1);}
        Output_view.move_car(car.getCar(),car.getCarState());
    }
    private void game_finish() {
        String winner = "";
        int max_state = 0;
        for(Car car : carList){
            if(max_state < car.getCarState()){
                winner = car.getCar();
                max_state = car.getCarState();
            } else if (max_state == car.getCarState()) {
                winner = String.format("%s, %s", winner, car.getCar());
            }
        }
        Output_view.ResultOfTheGame(winner);
    }
}

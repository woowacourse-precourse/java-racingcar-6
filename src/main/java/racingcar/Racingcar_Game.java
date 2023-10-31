package racingcar;

import racingcar.util.Car;
import racingcar.util.Chicken_Dinner;
import racingcar.util.Go_Stop_Selector;
import racingcar.util.Move_Selector;
import racingcar.viewer.Input_Viewer;
import racingcar.viewer.Output_Viewer;

import java.util.List;
import java.util.stream.Collectors;

public class Racingcar_Game {
    private final Chicken_Dinner play;
    private final Move_Selector move_selector = new Go_Stop_Selector();
    public Racingcar_Game() {
        List<String> car = Input_Viewer.Name_Request();
        int round = Input_Viewer.Number_of_Play_Request();
        play = new Chicken_Dinner(Set_Player_Car(car),round);
    }

    private List<Car> Set_Player_Car(List<String> car){
        return car.stream().map(Car::new).collect(Collectors.toList());
    }

    public void Game_Start() {
        Output_Viewer.Result_Message();
        Run_Game_Rounds();
        List<Car> Winner_name = play.Find_Winner();
        Output_Viewer.Winners(Winner_name);
    }

    private void Run_Game_Rounds() {
        while(play.Check_Round_Over()) {
            play.One_Round(move_selector);
            Output_Viewer.Status(play.Get_Car());
        }
    }
}
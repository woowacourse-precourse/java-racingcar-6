package racingcar.util;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Play {
    final List<Car> car;
    private Round round;
    private int round_index;

    public Play(List<Car> car_name, int round) {
        this.car = new ArrayList<>(car_name);
        this.round= new Round(round,0);
    }
    public void One_Round(Move_Selector move_selector) {
        for(Car car : car) {
            car.Position_Move(move_selector);
        }
        this.Set_Round_Index(round.Increase());
    }

    private void Set_Round_Index(int round_index){
        this.round_index=round_index;
    }

    public boolean Check_Round_Over(){
        if(round.Get_Round_Remaining()<=0){
            return false;
        }
        return true;
    }

    public List<Car> Get_Car() {
        return new ArrayList<>(car);
    }
}

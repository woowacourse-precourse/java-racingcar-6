package model;

import camp.nextstep.edu.missionutils.Randoms;
import view.RacingcarView;

import java.util.ArrayList;
import java.util.List;

public class RacingcarModel {
    private List<String> car_names;
    private int repeat;
    RacingcarView rv = new RacingcarView();

    public RacingcarModel(List<String> car_names, String repeat){
        this.car_names = car_names;
        this.repeat = Integer.parseInt(repeat);
    }

    public void RacingStart(){
        List<Integer> forward_count = new ArrayList<>();
        int n = 0;

        for(int i=0; i<car_names.size(); i++){
            n = 0;
            for(int j=0; j<repeat; j++){
                if(Randoms.pickNumberInRange(0,9) >= 4)
                    n++;
            }
            forward_count.add(n);
        }
        rv.showForwardCount(car_names, forward_count);
        Winner();
    }
    private void Winner(){

        // view 호출
    }


}

package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import view.RacingcarView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static view.RacingcarView.printResultHead;

public class RacingcarModel {
    private  List<String> car_names;
    private  int repeat;
    RacingcarView rv = new RacingcarView();

    public RacingcarModel(List<String> car_names, String repeat){
        this.car_names = car_names;
        this.repeat = Integer.parseInt(repeat);
    }
    public void RacingStart(){
        RacingResult();
    }
    private void RacingResult(){

        List<String> car_forward_result = new ArrayList<>();
        List<Integer> car_forward_count =new ArrayList<>();
        init(car_forward_result, car_forward_count);


        ResultForward(car_forward_result, car_forward_count);
        getWinner(car_forward_count);
    }
    private void init(List<String> car_forward_result, List<Integer> car_forward_count){
        for(int i=0; i< car_names.size(); i++){
            car_forward_result.add(car_names.get(i));
            car_forward_count.add(0);
        }
    }
    private void ResultForward(List<String> car_forward_result, List<Integer> car_forward_count){
        for(int i=0; i<repeat; i++){
            for(int j=0; j< car_names.size(); j++){
                if(Randoms.pickNumberInRange(0,9) >= 4){
                    car_forward_count.set(j,1+car_forward_count.get(j));
                }
            }
            rv.showForwardResult(car_forward_result, car_forward_count);
        }
    }
    private void getWinner(List<Integer> car_forward_count){
        String winner = "";
        int max = getMaxValue(car_forward_count);

        for(int i=0; i<car_forward_count.size(); i++){
            if(car_forward_count.get(i) == max){
                winner += car_names.get(i) + ", ";
            }
        }
        if (winner.endsWith(", ")) {
            winner = winner.substring(0, winner.length() - 2);
        }
        rv.showWinner(winner);
    }
    private int getMaxValue(List<Integer> arr){
        int max = -1;

        for(int i=0; i< arr.size(); i++){
            if(max < arr.get(i))
                max = arr.get(i);
        }

        return max;
    }

}

package controller;

import model.RacingcarModel;
import java.util.Arrays;
import java.util.List;


public class RacingcarController {

    public void RacingInputCheck(String car_names, String repeat){
        RacingcarModel rm;
        List<String> car_names_list = SliceByComma(car_names);
        ErrorCheck(car_names_list, repeat);

        rm = new RacingcarModel(car_names_list, repeat);
        rm.RacingStart();
    }
    private void ErrorCheck(List<String> car_names_list, String repeat){

        for(int i=0; i<car_names_list.size(); i++){
            if(isCorrectLength(car_names_list.get(i))){
                throw new IllegalArgumentException("자동차 이름 입력 길이가 잘못됨.");
            }
        }
        if(!isNumeric(repeat)){
            throw new IllegalArgumentException("반복횟수가 숫자가 아님.");
        }
    }
    private boolean isCorrectLength(String car_name){
        return (car_name.length() == 0 || car_name.length() > 5);
    }

    private boolean isNumeric(String user_number) {
        return user_number.matches("\\d+");
    }

    private List<String> SliceByComma(String car_names){
        car_names = car_names.replaceAll("\\s", "");
        List<String> list = Arrays.asList(car_names.split(","));
        return list;
    }




}

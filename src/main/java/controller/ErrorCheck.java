package controller;

import java.util.List;

public class ErrorCheck {

    public void ErrorChecking(List<String> car_names_list, String repeat){

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
}

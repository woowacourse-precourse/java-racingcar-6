package controller;

import camp.nextstep.edu.missionutils.Console;
import model.RacingcarModel;
import view.RacingcarView;

import java.util.Arrays;
import java.util.List;




public class RacingcarController {
    private  final RacingcarView racingcarView = new RacingcarView();
    private  final ErrorCheck errorCheck = new ErrorCheck();

    public void run(){
        String car_names;
        String repeat;

        racingcarView.requestCarNamesMessage();
        car_names = Console.readLine();
        racingcarView.requestInputNumberOfRepeatMessage();
        repeat = Console.readLine();

        racingcarView.printResultHead();
        RacingInputCheck(car_names, repeat);
    }

    public void RacingInputCheck(String car_names, String repeat){
        RacingcarModel rm;
        List<String> car_names_list = SliceByComma(car_names);
        errorCheck.ErrorChecking(car_names_list, repeat);

        rm = new RacingcarModel(car_names_list, repeat);
        rm.RacingStart();
    }


    private List<String> SliceByComma(String car_names){
        car_names = car_names.replaceAll("\\s", "");
        List<String> list = Arrays.asList(car_names.split(","));
        return list;
    }




}

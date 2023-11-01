package controller;

import camp.nextstep.edu.missionutils.Console;
import model.RacingcarModel;
import view.RacingcarView;

import java.util.Arrays;
import java.util.List;


/*
 * 클래스 이름 : RacingcarController
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-11-01
 *
 * 내용 : 사용자의 Input 값을 받고 이를 원하는 데이터로 처리하는 클래스
 *
 * 작성자 : 문재경
 */

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

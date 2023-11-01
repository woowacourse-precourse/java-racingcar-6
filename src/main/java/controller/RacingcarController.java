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

    /*
     * 유저의 입력을 받고 이 값을 RacingInputCheck 에 넘겨주는 메서드
     *
     * @param void
     * @return void
     */
    public void run(){
        String car_names;
        String repeat;

        racingcarView.requestCarNamesMessage();
        car_names = Console.readLine();
        racingcarView.requestInputNumberOfRepeatMessage();
        repeat = Console.readLine();

        racingcarView.printResultHead();
        RacingInputManagement(car_names, repeat);
    }

    /*
     * 유저의 Input String 값을 관리해서 처리해주는 메서드
     *
     * @param String car_names, String repeat
     * @return void
     */
    public void RacingInputManagement(String car_names, String repeat){
        List<String> car_names_list = SliceByComma(car_names);

        errorCheck.ErrorChecking(car_names_list, repeat);
        RacingcarModelConstructor(car_names_list, repeat);
    }

    /*
     * 유저의 Input 값들을 RacingcarModel 객체를 생성 후 실행해주는 메서드
     *
     * @param List<String> car_names_list, String repeat
     * @return void
     */
    public void RacingcarModelConstructor(List<String> car_names_list, String repeat){
        RacingcarModel rm = new RacingcarModel(car_names_list, repeat);
        rm.RacingStart();
    }

    /*
     * String 값을 공백을 제거하고 ',' 기준으로 나눠서 리스트로 변환해주는 메서드
     *
     * @param String car_names
     * @return List<String>
     */
    private List<String> SliceByComma(String car_names){
        car_names = car_names.replaceAll("\\s", "");
        return Arrays.asList(car_names.split(","));
    }




}

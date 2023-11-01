package model;

import camp.nextstep.edu.missionutils.Randoms;
import view.RacingcarView;

import java.util.ArrayList;
import java.util.List;

/*
 * 클래스 이름 : RacingcarModel
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-11-01
 *
 * 내용 : 사용자의 Input 값에 따라 자동차 경주 알고리즘을 돌리는 클래스
 *
 * 작성자 : 문재경
 */
public class RacingcarModel {
    private  List<String> car_names;
    private  int repeat;
    RacingcarView rv = new RacingcarView();

    public RacingcarModel(List<String> car_names, String repeat){
        this.car_names = car_names;
        this.repeat = Integer.parseInt(repeat);
    }
    public void RacingStart(){
        List<String> car_forward_result = new ArrayList<>();
        int[] car_forward_count = new int[car_names.size()];
        init(car_forward_result, car_forward_count);
        RacingResult(car_forward_result, car_forward_count);
    }
    private void RacingResult(List<String> car_forward_result, int[] car_forward_count){
        ResultForward(car_forward_result, car_forward_count);
        getWinner(car_forward_count);
    }
    private void init(List<String> car_forward_result, int[] car_forward_count){
        for(int i=0; i< car_names.size(); i++){
            car_forward_result.add(car_names.get(i));
            car_forward_count[i] = 0;
        }
    }
    private void ResultForward(List<String> car_forward_result, int[] car_forward_count){
        for(int i=0; i<repeat; i++){
            for(int j=0; j< car_names.size(); j++){
                if(Randoms.pickNumberInRange(0,9) >= 4){
                    car_forward_count[j]++;
                }
            }
            rv.showForwardResult(car_forward_result, car_forward_count);
        }
    }
    private void getWinner(int[] car_forward_count){
        String winner = "";
        int max = getMaxValue(car_forward_count);

        for(int i=0; i<car_forward_count.length; i++){
            if(car_forward_count[i] == max){
                winner += car_names.get(i) + ", ";
            }
        }
        if (winner.endsWith(", ")) {
            winner = winner.substring(0, winner.length() - 2);
        }
        rv.showWinner(winner);
    }
    private int getMaxValue(int[] arr){
        int max = -1;

        for(int i=0; i< arr.length; i++){
            if(max < arr[i])
                max = arr[i];
        }

        return max;
    }

}

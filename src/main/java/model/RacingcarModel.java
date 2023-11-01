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

    /*
     * 자동차 경주를 위해 필요한 변수 생성 후 결과 메서드에 넘겨주는 메서드
     *
     * @param void
     * @return void
     */
    public void RacingStart(){
        int[] car_forward_count = new int[car_names.size()]; // 자동차의 각 전진 횟수를 기록하는 배열
        init(car_forward_count);
        RacingResult(car_forward_count);
    }
    /*
     * 전진 횟수의 배열들을 모두 0 으로 초기화 해주는 메서드
     *
     * @param int[] car_forward_count
     * @return void
     */
    private void init(int[] car_forward_count){
        for(int i=0; i< car_names.size(); i++)
            car_forward_count[i] = 0;
    }

    /*
     * 자동차 경주의 과정과 승자를 View 에 넘겨주는 메서드
     *
     * @param int[] car_forward_count
     * @return void
     */
    private void RacingResult(int[] car_forward_count){
        for(int i=0; i<repeat; i++) {
            ResultForward(car_forward_count);
            rv.showForwardResult(car_names, car_forward_count);
        }
        rv.showWinner(getWinner(car_forward_count));
    }

    /*
     * 각 횟수 마다 자동차의 전진을 판단해주고 전진 결과를 배열에 저장하는 메서드
     *
     * @param  int[] car_forward_count
     * @return void
     */
    private void ResultForward(int[] car_forward_count){
        for(int j=0; j< car_names.size(); j++){
            if(Randoms.pickNumberInRange(0,9) >= 4){
                car_forward_count[j]++;
            }
        }
    }

    /*
     * 자동차 경주의 승자를 return 해주는 메서드
     *
     * @param int[] car_forward_count
     * @return String winner
     */
    private String getWinner(int[] car_forward_count){
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
        return winner;
    }

    /*
     * 배열에서 가장 큰 값을 반환하는 메서드
     *
     * @param int[] arr
     * @return return max
     */
    private int getMaxValue(int[] arr){
        int max = -1;

        for(int i=0; i< arr.length; i++){
            if(max < arr[i])
                max = arr[i];
        }

        return max;
    }

}

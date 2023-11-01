package view;

import static view.Constant.*;

import java.util.List;

/*
 * 클래스 이름 : RacingcarView
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-11-01
 *
 * 내용 : 사용자가 보는 모든 보이는 부분을 관리하는 클래스
 *
 * 작성자 : 문재경
 */
public class RacingcarView {
    public static void requestCarNamesMessage(){
        System.out.println(START_GAME);
    }
    public static void requestInputNumberOfRepeatMessage(){
        System.out.println(INPUT_NUMBER);
    }

    public static void printResultHead(){
        System.out.println();
        System.out.println(EXECUTION_RESULT);
    }

    /*
     * 각 횟수 마다 자동차의 전진을 출력해주는 메서드
     *
     * @param List<String> car_forward, int[] car_forward_count
     * @return void
     */

    public void showForwardResult(List<String> car_forward, int[] car_forward_count){
        for(int i=0; i<car_forward.size(); i++){
            System.out.print(car_forward.get(i) + " : ");
            for(int j=0; j<car_forward_count[i]; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * 우승자를 출력하는 메서드
     *
     * @param String winner
     * @return void
     */

    public void showWinner(String winner){
        System.out.println(FINAL_WINNER + winner);
    }

}

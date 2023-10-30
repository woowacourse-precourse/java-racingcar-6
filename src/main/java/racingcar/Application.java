package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Application {
    // 입력값 받기
    static InputValue inputValue  = new InputValue();
    static InputValue inputTime  = new InputValue();
    static String[] value;
    static Integer time;

    //랜덤 거리
    static RandomDistance randomDis = new RandomDistance();
    static List<Integer> userDis = new ArrayList<>();
    //최종 우승자 저장
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        value = inputValue.getInputValue();
        System.out.println("시도할 회수는 몇회인가요?");
        time = inputTime.getInputTime();
        System.out.println("실행 결과");

        for (int i=0; i<time; i++){
            play();
        System.out.println(" ");
        }
        System.out.println("최종 우승자 : " + finalWinner());
    }
    //플레이
    public static void play(){
        for(int j=0; j<value.length;j++){
            userDis.add(j,randomDis.getDistance(j));
            //길이 값을 문자로 변환
            String dis = "-".repeat(userDis.get(j));
            System.out.println(value[j] + " :" + dis);
        }
    }
    //최종 우승자 구하기
    public static List<String> finalWinner(){
        for (int i=0; i<value.length; i++){
            if (Objects.equals(userDis.get(i), Collections.max(userDis))){
                answer.add(value[i]);
            }
        }
        return answer;
    }
}

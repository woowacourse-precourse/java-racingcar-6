package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // 입력값 받기
        InputValue inputValue  = new InputValue();
        InputValue inputTime  = new InputValue();
        //랜덤 거리
        RandomDistance randomDis = new RandomDistance();
        List<Integer> userDis = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] value = inputValue.getInputValue();
        System.out.println("시도할 회수는 몇회인가요?");
        Integer time = inputTime.getInputTime();
        System.out.println("실행 결과");

        for (int i=0; i<time; i++){
            for(int j=0; j<value.length;j++){
                userDis.add(j,randomDis.getDistance(j));
                //길이 값을 문자로 변환
                String dis = "-".repeat(userDis.get(j));
                System.out.println(value[j] + " :" + dis);
            }
        System.out.println(" ");
        }
        //최종 우승자 구하기
        List<String> answer = new ArrayList<>();
        for (int i=0; i<value.length; i++){
            if (Objects.equals(userDis.get(i), Collections.max(userDis))){
                answer.add(value[i]);
            }
        }
        System.out.println("최종 우승자 : " + answer);
    }
}

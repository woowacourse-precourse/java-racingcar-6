package racingcar;

import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 입력값 받기
        InputValue inputValue  = new InputValue();
        InputValue inputTime  = new InputValue();
        //랜덤 거리
        RandomDistance randomDis = new RandomDistance();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] value = inputValue.getInputValue();
        System.out.println("시도할 회수는 몇회인가요?");
        Integer time = inputTime.getInputTime();
        System.out.println("실행 결과");


        for(int i=0; i<value.length;i++){
            String userDis = randomDis.getDistance(time);
            System.out.println(value[i] + " :" + userDis);
        }
        System.out.println(" ");

        System.out.println("최종 우승자 : ");
    }
}

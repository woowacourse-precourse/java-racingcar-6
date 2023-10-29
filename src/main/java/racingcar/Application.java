package racingcar;

import racingcar.controller.InputTries;

import java.util.List;

import static racingcar.controller.InputParticipantes.InputParticipantes;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> participantes=InputParticipantes();
        System.out.println("시도할 회수는 몇회인가요?");
        int tries=InputTries.getTries();
        System.out.println();
        System.out.println("실행 결과");
    }
}
//pobi,woni,jun

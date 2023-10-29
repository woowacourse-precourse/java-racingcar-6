package racingcar;

import java.util.List;

import static racingcar.controller.InputParticipantes.InputParticipantes;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> participantes=InputParticipantes();
    }
}
//pobi,woni,jun

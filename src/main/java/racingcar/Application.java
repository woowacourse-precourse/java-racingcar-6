package racingcar;

import racingcar.controller.GameController;
import racingcar.entity.Tries;

import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;


public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> participantes=InputParticipantes();
        
        GameController gameController=new GameController();
        System.out.println(participantes);
        System.out.println("시도할 회수는 몇회인가요?");
        int tries= Tries.getTries();
        System.out.println("실행 결과");
        for(int i=0; i<tries;i++){
            gameController.GameStart(participantes);
            System.out.println("실행");
        }
    }
}
//pobi,woni,jun

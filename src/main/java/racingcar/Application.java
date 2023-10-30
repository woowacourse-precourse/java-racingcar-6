package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.MaxController;
import racingcar.entity.Tries;

import java.util.ArrayList;
import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;
import static racingcar.entity.Winner.InputWinner;
import static racingcar.generator.DashStringGenerator.DashStringGenerator;


public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> participantes=InputParticipantes();
        GameController gameController=new GameController();
        MaxController maxController=new MaxController();
        List<Integer> index = new ArrayList<Integer>();
        List<String> name = new ArrayList<String>();
        System.out.println(participantes);
        System.out.println("시도할 회수는 몇회인가요?");
        int tries= Tries.getTries();
        System.out.println("실행 결과");
        for(int i=0; i<tries;i++){
            gameController.GameStart(participantes);
            for (int j = 0; j < participantes.size(); j++) {
                String dashString = DashStringGenerator(j, gameController.win);
                System.out.println(participantes.get(j) + " : " + dashString);
            }
            System.out.println();
        }
        int[] forwinner = gameController.win;
        int max=0;
        for (int i=0;i<forwinner.length;i++){
            max= maxController.findMax(max,forwinner[i]);
        }
        for (int i=0;i<forwinner.length;i++){
            if(max==forwinner[i]){
                index.add(i);
            }
        }

        for(int i=0;i<index.size();i++){
            name.add(participantes.get(i));
        }
        System.out.print("최종 우승자 : ");
        for(int i=0;i< name.size();i++){
            if(i==0) {
                System.out.print(name.get(i));
            }
            else{
                System.out.print(", "+name.get(i));
            }
        }
    }
}

//pobi,woni,jun

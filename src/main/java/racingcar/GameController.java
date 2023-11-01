package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameView view;
    private List<Car> cars;
    private int num;
    public GameController(){
        view = new GameView();
    }
    public void createGame(){
        this.cars = view.inputCars();
        this.num = view.inputNum();
    }
//    게임 진행
    public void gameSet(){
        int count= 0;
        System.out.println("실행 결과");
        while (count < num){
            printProcessGame();
            count++;
        }
        gameEnd();
    }
//    게임 종료
    public void gameEnd(){
        System.out.print("최종 우승자 : " );
        List<String> winner = getWinner();
        for (int i =0; i<winner.size()-1; i++){
            System.out.print(winner.get(i)+", ");
        }
        System.out.print(winner.get(winner.size()-1));
    }


}

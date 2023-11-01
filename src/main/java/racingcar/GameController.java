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
//    ------------------------------------------------------

    //  부가적으로 필요한 함수들
    public void printProcessGame(){
        for (Car car : cars){
            if (choiceGoStop()) {
                int count = car.getCount();
                count++;
                car.setCount(count);
            }
            System.out.print(car.getName() + " : ");
            view.printSlash(car.getCount());
        }
        System.out.println(); //개행넣기.
    }
    public boolean choiceGoStop(){
        int randNum = Randoms.pickNumberInRange(0,9);
        return randNum>=4;
    }

    public List<String> getWinner(){
        List<String> winner = new ArrayList<>();
        int maxCount = findMaxCount();
        for (Car car : cars){
            if(maxCount == car.getCount()){
                winner.add(car.getName());
            }
        }
        return winner;
    }

    public int findMaxCount(){
        int maxCount = 0;
        for (Car car : cars){
            if(maxCount<car.getCount()){
                maxCount=car.getCount();
            }
        }
        return maxCount;
    }

}

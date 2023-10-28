package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private List<Car> cars;
    private int repeat;
    private InputManager inputManager;
    private MassageManager massageManager;

    public GameManager() {
        cars = new ArrayList<>();
        inputManager = new InputManager();
        massageManager = new MassageManager();
    }

    private void checkMovePossible(Car car){
        int random = createRandomNumber();
        if(random >= 4){
            car.move();
        }
    }

    private int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    private void selectWinner(List<Car> cars){
        Collections.sort(cars, Collections.reverseOrder());
        int maxDistance = cars.get(0).getDistance();
        String output = MassageManager.FINAL_WINNER + cars.get(0).getName();

        for (int i = 1; i<cars.size(); i++){
            if (maxDistance == cars.get(i).getDistance()){
                output += ", " + cars.get(i).getName();
            }else{
                break;
            }
        }
        System.out.println(output);
    }

    public void startGame(){
        // 자동차 이름, 반복 횟수 입력
        cars = inputManager.inputCarName();
        repeat = inputManager.inputRepeat();

        //차수 실행
        System.out.println("\n"+MassageManager.RESULT_STAGE);
        for (int i = 0; i<repeat; i++){
            startStage();
            System.out.println();
        }

        //우승자 결과
        selectWinner(cars);
    }

    private void startStage(){
        for (int i = 0; i<cars.size(); i++){
            Car car = cars.get(i);
            checkMovePossible(car);
            massageManager.stageResult(car);
        }
    }
}

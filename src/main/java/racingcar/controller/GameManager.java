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

    protected void checkMovePossible(Car car){
        int random = createRandomNumber();
        if(random >= 4){
            car.move();
        }
    }

    protected int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    protected List<String> selectWinner(List<Car> cars){
        Collections.sort(cars, Collections.reverseOrder());
        int maxDistance = cars.get(0).getDistance();

        List<String> names = new ArrayList<>();
        names.add(cars.get(0).getName());

        for (int i = 1; i<cars.size(); i++){
            if (maxDistance == cars.get(i).getDistance()){
                names.add(cars.get(i).getName());
            }else{
                break;
            }
        }

        return names;
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
        massageManager.showWinner(selectWinner(cars));
    }

    protected void startStage(){
        for (int i = 0; i<cars.size(); i++){
            Car car = cars.get(i);
            checkMovePossible(car);
            massageManager.stageResult(car);
        }
    }
}

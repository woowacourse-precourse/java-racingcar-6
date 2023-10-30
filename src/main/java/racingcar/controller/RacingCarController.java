package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Judgment;
import racingcar.domain.Random;
import racingcar.domain.User;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    User user=new User();
    InputView inputView=new InputView();
    Judgment judgment=new Judgment();
    Random random=new Random();

    private List<Car> cars=new ArrayList<>();
    public void start(){
        cars=user.nameForCar(inputView.inputCars());
        int count=inputView.inputCount();
        repeat(count);

    }

    private void repeat(int count){
        for(int num=0;num<count;num++){
            startForEach();
        }
    }
    
    private void startForEach(){
        for(int num=0;num<cars.size();num++){
            if(judgment.isNumberFourOrMore(random.createNumber())){
                cars.get(num).moveForward();
                continue;
            }
            cars.get(num).moveStop();
        }
    }
}

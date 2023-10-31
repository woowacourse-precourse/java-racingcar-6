package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    User user=new User();
    InputView inputView=new InputView();
    OutputView outputView=new OutputView();
    Judgment judgment=new Judgment();
    Random random=new Random();
    Referee referee=new Referee();

    private List<Car> cars=new ArrayList<>();
    public void start(){
        cars=user.nameForCar(inputView.inputCars());
        int count=inputView.inputCount();
        repeat(count);
        outputView.printWinner(referee.announceWinner(referee.decideWinner(cars)));
    }

    private void repeat(int count){
        System.out.println("실행 결과");
        for(int num=0;num<count;num++){
            startForEach();
            System.out.println();
        }
    }
    
    private void startForEach(){
        for(int num=0;num<cars.size();num++){
            if(judgment.isNumberFourOrMore(random.createNumber())){

                outputView.printForEach(cars.get(num),cars.get(num).moveForward());
                continue;
            }

            outputView.printForEach(cars.get(num),cars.get(num).moveStop());
        }
    }
}

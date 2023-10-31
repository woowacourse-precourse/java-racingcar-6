package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.CarHashMap;
import racingcar.View.PrintView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainController {

    PrintView view = null;
    int times;
    InputController inputController = null;
    CarHashMap cars = null;

    public MainController(){
        view = new PrintView();
        inputController = new InputController();
    }

    public void setCarRacing(){
        view.firstSentenceView();
        String[] time = inputController.inputCarNames();
        view.secondSentenceView();
        times = inputController.inputTimes();
        cars = new CarHashMap(time);
    }

    public void startRacing(){

        for(int i = 0; i < times; i++){
            Iterator<String> it = cars.getIterator();
            while(it.hasNext()){
                int num = Randoms.pickNumberInRange(0, 9);
                if(num >= 4) {
                    cars.increaseValue(it.next());
                }else
                    it.next();
            }
            view.gameStartView(cars, times);
        }

    }

    public void winnerCheck(){
        Set<String> winners = new HashSet<>();

        Iterator<String> it = cars.getIterator();
        int max = 0;

        while(it.hasNext()){
            String name = it.next();
            if(cars.getValue(name) > max) {
                max = cars.getValue(name);
            }
        }

        it = cars.getIterator();
        while(it.hasNext()){
            String name = it.next();
            if(cars.getValue(name) == max)
                winners.add(name);
        }

        view.gameResultView(winners);
    }


}

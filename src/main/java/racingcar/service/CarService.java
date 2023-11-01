package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public List<Car> namesToCarList(String line){
        String[] names = line.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : names){
            name = name.trim();
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public int checkTryCount(String line){
        int count = Integer.parseInt(line);
        if(count <= 0 || count > Integer.MAX_VALUE){
            throw new IllegalArgumentException();
        }
        return count;
    }

    public boolean hasMovingForward(){
        int rand = Randoms.pickNumberInRange(0, 9);
        if(rand >= 4){
            return true;
        }
        return false;
    }

    public List<String> getWinnerToList(List<Car> cars){
        List<String> names = new ArrayList<>();
        int max = 0;
        for(Car car : cars){
            max = Math.max(max, car.getDistance());
        }

        for(Car car : cars){
            if(car.getDistance() == max){
                names.add(car.getName());
            }
        }
        return names;
    }

    public void printWinner(List<String> winners){
        if(winners.size() > 1){
            OutputView.printDeadHead(winners);
        }else{
            OutputView.printWinner(winners.get(0));
        }
    }


}

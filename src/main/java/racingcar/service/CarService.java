package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.CarParser;
import racingcar.view.TextInterface;

import java.util.List;

public class CarService {
    private final TextInterface textInterface = new TextInterface();
    private final CarParser carParser = new CarParser();

    public List<Car> enterCars(){
        textInterface.inputCarsNameMessage();
        return setCars(Console.readLine());
    }

    public List<Car> setCars(String input){
        List<Car> carList = carParser.stringToCarList(input);
        return carList;
    }

    public void forwardAndPrintCar(List<Car> cars){
        for(Car car : cars){
            car.randomForward(Randoms.pickNumberInRange(0,9));
            car.printForward();
        }
    }

    public int findWinForward(List<Car> cars){
        int winForward = 0;
        for(Car car : cars){
            if(car.getForward() > winForward){
                winForward = car.getForward();
            }
        }
        return winForward;
    }

    public int countWinner(List<Car> cars, int winForward){
        int winner = 0;
        for(Car car : cars){
            if(car.getForward() == winForward){
                winner++;
            }
        }
        return winner;
    }

    public void printWinner(List<Car> cars, int winner, int winForward){
        String message = "최종 우승자 : ";
        if(winner == 1){
            for(Car car : cars){
                message += soloWin(car, winForward);
            }
        }
        if(winner > 1){
            for(Car car : cars){
                message += multiWin(car, winForward);
            }
            int len = message.length();
            message = message.substring(0, len-2); // 문자열 끝 쉼표 제거
        }
        System.out.println(message);
    }

    public String soloWin(Car car, int winForward){
        if(car.getForward() == winForward){
            return car.getName();
        }
        return "";
    }

    public String multiWin(Car car, int winForward){
        if(car.getForward() == winForward){
            return car.getName() + ", ";
        }
        return "";
    }
}

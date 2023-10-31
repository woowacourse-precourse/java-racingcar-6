package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import data.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final static int GO = 4;
    List<Car> cars;
    int tryLimit;
    int max;
    List<Car> winnerCars;

    public RacingCarGame(){
        cars = new ArrayList<>();
        tryLimit = 0;
        int max = -1;
        winnerCars = new ArrayList<Car>();
    }

    public void run() {
        inputNames(splitInputNames());
        inputTryLimit();
        System.out.println();
        System.out.println(race());
        setMax();
        setWinnerCars();
        System.out.println(getWinnerNames());
    }

    //Test 코드를 작성하다가 역할이 2개인 메서드를 찾아 분리시킬 수 있게 되었다.
    public String[] splitInputNames(){
        String[] names;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        names = inputNames.split(",");
        return names;
    }
    //private void inputNames(){
    public void inputNames(String[] names){
        if(names.length>0){
            for(String name : names){
                cars.add(new Car(name));
            }
        }
    }

    //private void inputTryLimit(){
    public void inputTryLimit(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryLimit = Console.readLine();
        tryLimit = Integer.parseInt(inputTryLimit);
    }

    //private String raceForOneTry(){
    public String raceForOneTry(){
        StringBuilder result = new StringBuilder();
        int command;
        for(Car car : cars){
            command = Randoms.pickNumberInRange(1,9);
            if(command >= GO)
                car.add();
            result.append(car)
                    .append("\n");
        }
        return result.toString();
    }

    //private String race(){
    public String race(){
        StringBuilder result = new StringBuilder();
        System.out.println("실행 결과");
        for(int tryNum = 0; tryNum < tryLimit; tryNum++){
            result.append(raceForOneTry())
                    .append("\n");
        }
        return result.toString();
    }

    //private void setMax(){
    public void setMax(){
        for(Car car : cars){
            int currentLength = car.getTrackLength();
            if(currentLength>max) {
                max = currentLength;
            }
        }
    }

    //private void setWinnerCars(){
    public void setWinnerCars(){
        for(Car car : cars){
            if(car.getTrackLength() == max)
                winnerCars.add(car);
        }
    }

    //private String getWinnerNames(){
    public String getWinnerNames(){
        StringBuilder winners = new StringBuilder();
        winners.append("최종 우승자 : ");
        for(int index = 0; index < winnerCars.size(); index++){
            Car car = winnerCars.get(index);
            winners.append(car.getName());
            if(index != winnerCars.size()-1)
                winners.append(", ");
        }
        return winners.toString();
    }
}

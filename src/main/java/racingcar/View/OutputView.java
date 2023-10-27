package racingcar.View;

import racingcar.Model.Car;

import java.util.*;

public class OutputView {
    public void outputResult(List<Car> cars){
        for(int i=0;i < cars.size();i++){
            printCarResult(cars.get(i));
        }
        System.out.println("");
    }

    public void outputWinner(List<Car> cars){
        Collections.sort(cars, ((o1, o2) -> o1.getLocation() - o2.getLocation()));
        int maxNum = cars.get(cars.size()-1).getLocation();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < cars.size();i++){
            if(cars.get(i).getLocation() == maxNum){
                sb.append(cars.get(i).getName()).append(", ");
            }
        }
        sb.delete(sb.lastIndexOf(","),sb.length()-1);
        System.out.println("최종 우승자 : " + sb);

    }

    private void printCarResult(Car car) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < car.getLocation();i++){
            sb.append("-");
        }
        System.out.println(car.getName() + " : " + sb);
    }


}

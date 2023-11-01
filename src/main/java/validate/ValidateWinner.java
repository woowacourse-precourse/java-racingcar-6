package validate;

import domain.Car;
import domain.GameOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateWinner {

    private ValidateWinner(){

    }

    public static String checkJointWinner(Car[] carslist,int carnumbers) {
        List<String> cars = new ArrayList<>();
        List<Integer> integerdistance= new ArrayList<>();
        int max = 0;
        List<String> winner = new ArrayList<>();
        String answers ="";
        String commas= (", ");
        // 카 이름과 distance length를 각 List에 박아넣자.

        for (int i = 0; i < carnumbers; i++) {
            cars.add(carslist[i].getCarname());
            integerdistance.add(carslist[i].getDistance().length());
            if (max<integerdistance.get(i)){
                max=integerdistance.get(i);
            }
        }
        for (int i = 0; i < carnumbers; i++) {

            if (max==integerdistance.get(i)){
                winner.add(cars.get(i));
            }
        }
        // 4명이서 해서 공동우승 4면
        // 0 1 2 3
        // 0 , 2 3 4
        // 0 , 2 , 4 , 6
        // 홀수번째 리스트에 추가해주면 됨
        // String.join(구분 스트링,list) 할 시 구분점 잡아서 리턴
        answers = String.join(", ",winner);

        return answers;
    }

}

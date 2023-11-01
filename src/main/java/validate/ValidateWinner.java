package validate;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class ValidateWinner {

    // new로 객체 생성해주는건 final 찍어도 됨 객체주소 지정하고 이어붙이는 형식이라
    private final static List<String> cars = new ArrayList<>();
    private final static List<Integer> integerdistance = new ArrayList<>();
    private final static List<String> winner = new ArrayList<>();
    private static int max = 0;
    //final int max => 한번 찍히면 재할당 힘들어짐
    private static String answers = "";
    private final static String commas = (", ");

    private ValidateWinner() {
    }

    public static String checkJointWinner(Car[] carslist, int carnumbers) {
        // 카 이름과 distance length를 각 List에 박아넣자.
        cars(carnumbers, carslist);
        checkJoint(carnumbers);

        // 4명이서 해서 공동우승 4면
        // 0 1 2 3
        // 0 , 2 3 4
        // 0 , 2 , 4 , 6
        // 홀수번째 리스트에 추가해주면 됨
        // String.join(구분 스트링,list) 할 시 구분점 잡아서 리턴
        answers = String.join(commas, winner);
        return answers;
    }

    private static void cars(int carnumbers, Car[] carslist) {
        for (int i = 0; i < carnumbers; i++) {
            cars.add(carslist[i].getCarName());
            setIntegerDistance(i, carslist);
        }
    }

    private static void setIntegerDistance(int i, Car[] carslist) {
        integerdistance.add(carslist[i].getDistance().length());
        if (max < integerdistance.get(i)) {
            max = integerdistance.get(i);
        }
    }

    private static void checkJoint(int carnumbers) {
        for (int i = 0; i < carnumbers; i++) {
            winnerAdd(i);
        }
    }

    private static void winnerAdd(int i) {
        if (max == integerdistance.get(i)) {
            winner.add(cars.get(i));
        }
    }

}

package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static Car[] car;
    public static int Try;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        makeCar();
        play();
        findWinner();
    }

    public static void makeCar(){
        ArrayList<String> names = inputName();
        Try = inputTry();
        car = new Car[names.size()];

        for(int i = 0; i < names.size(); i++){
            car[i] = new Car(names.get(i));
        }

    }
    public static void play(){
        System.out.println("\n실행결과");

        for(int i = 0; i < Try; i++){
            for(int j = 0; j < car.length; j++){
                System.out.print(car[j].name + " : ");
                car[j].makeMove();
                car[j].drawMove();
            }
            System.out.println();
        }
    }

    public static void findWinner(){
        int maxMove = 0;
        ArrayList<String> winner = new ArrayList<>();
        for(int i = 0; i < car.length; i++){
            if(car[i].move > maxMove){
                maxMove = car[i].move;
            }
        }

        for(int i = 0; i < car.length; i++){
            if(car[i].move == maxMove){
                winner.add(car[i].name);
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winner));

    }

    public static ArrayList<String> inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> list = new ArrayList<>();
        String input = Console.readLine();

        for(String i : input.split(",")){
            list.add(i);
        }

        return list;
    }

    public static void checkName(String name){
        if(name.length() == 0 || name.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    public static int inputTry(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}



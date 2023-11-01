package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car{

    public ArrayList<Integer> position= new ArrayList<>();
    private int Try;
    private final ArrayList<String> car = new ArrayList<>();


    void InputCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputValue = Console.readLine();
        car.add(Arrays.toString((inputValue.split(","))));

        for(int i=0;i<car.size();i++){
            if(car.get(i) == null ||car.get(i).isBlank()||car.get(i).length()>5){
                throw new IllegalArgumentException("에러가 발생했습니다.");
            }
        }
    }
    void InputTry(){
        System.out.println("시도할 횟수는 몇회인가요?");
        Try = Integer.parseInt((Console.readLine()));
    }
    void ExtractOutput(){
        for(int i=0;i<car.size();i++){
            System.out.print(car.get(i)+" : ");
            for(int j=0;j<position.get(i);j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    void Extract(){
        for(int i=0;i<car.size();i++){
            if(Randoms.pickNumberInRange(0, 9)>=4){
                int sum = position.get(i)+1;
                position.set(i, sum);
            }
        }
    }
    void Winner(){
        int max_position =0;
        List<String> winners = new ArrayList<>();
        for(int i=0;i<car.size();i++){
            if(position.get(i)>max_position){
                winners.clear();
                max_position = position.get(i);
                winners.add(car.get(i));
            }
            else if(position.get(i)==max_position){
                winners.add(car.get(i));
            }
        }
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : "+result);
    }
    void Play(){
        InputCar();
        InputTry();
        for(int i=0;i<car.size();i++){
            position.add(0);
        }
        for(int i=0;i<Try;i++){
            Extract();
            ExtractOutput();
        }
        Winner();
    }
}

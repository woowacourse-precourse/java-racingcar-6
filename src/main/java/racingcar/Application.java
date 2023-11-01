package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        List<String> cars = new ArrayList<>();
        int tryNum = 0;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            nameInput(cars);
        }catch (IllegalAccessException ignored) {}

        outFunc(cars, tryNum);
    }
    public static void nameInput (List<String> cars) throws IllegalAccessException{
        String userInput=Console.readLine();
        String[] car =userInput.split(",");
        for (String name : car){
            cars.add(name.trim());
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void outFunc(List<String> cars, int tryNum){
        List<Integer> go = new ArrayList<>();
        int i = 0;
        int many = cars.size();
        while(i < tryNum){
            howManyGo(cars,go,many);
            i++;
        }
        System.out.print("최종 우승자 : "+cars.get(winnerIndex(go,many)));
    }
    public static void howManyGo(List<String> cars,List<Integer> go, int many){
        for(int i=0;i<many;i++){
            if(isCarMoved())
                go.set(i, go.get(i)+1);
            System.out.print(cars.get(i) +" : ");
            toPrint(i);
        }

    }

    public static boolean isCarMoved(){
        int pickNum = pickNumberInRange(0,9);
        return pickNum >= 4;
    }

    public static void toPrint(int num){
        for(int i=0;i<num;i++){
            System.out.print('-');
        }
    }

    public static int winnerIndex(List<Integer> go, int many){
        int index=0;
        for(int i=0;i<many-1;i++){
            if(go.get(i)> go.get(i+1)) index=i;
        }
        return index;
    }
}

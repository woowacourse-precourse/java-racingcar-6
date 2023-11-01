package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        nameInput(cars);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum =tryNumInput();
        outFunc(cars, tryNum);
    }
    public static int tryNumInput(){
        int numInput = Integer.parseInt(Console.readLine());
        return numInput;
    }
    public static void nameInput(List<String> cars){
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
        for(int j=0;j<cars.size();j++) go.add(j,0);
        int i = 0;
        int many = cars.size();
        System.out.println("실행 결과");
        while(i < tryNum){
            howManyGo(cars,go,many);
            i++;
        }
        printWinner(go,many,cars);
       }
    public static void howManyGo(List<String> cars,List<Integer> go, int many){
        for(int i=0;i<many;i++){
            if(isCarMoved())
                go.set(i, go.get(i)+1);
            System.out.print(cars.get(i) +" : ");
            toPrint(go,i);
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCarMoved(){
        int pickNum = pickNumberInRange(0,9);
        return pickNum >= 4;
    }

    public static void toPrint(List<Integer> go, int num){
        for(int i=0;i<go.get(num);i++){
            System.out.print("-");
        }
    }

    public static List<Integer> winnerIndex(List<Integer> go, int many){
        ArrayList<Integer> whoIsWinner = new ArrayList<>();
        whoIsWinner.add(0,0);
        int firstNumWinner =whoIsWinner.get(0);
        for(int i=0;i<many;i++){
            if(go.get(i)> firstNumWinner){
                whoIsWinner.clear();
                whoIsWinner.add(i);
            }
            else if(Objects.equals(go.get(i), go.get(firstNumWinner)))
                whoIsWinner.add(i);
        }
        return whoIsWinner;
    }

    public static void printWinner(List<Integer> go, int many, List<String> cars){
        List<Integer> winner = winnerIndex(go,many);
        int winnerIndexSize = winnerIndex(go,many).size();
        System.out.print("최종 우승자 : ");
        for(int i=0;i<winnerIndexSize;i++) {
            System.out.print(cars.get(winner.get(i)));
            if(i<winnerIndexSize-1) System.out.print(", ");
        }


    }
}
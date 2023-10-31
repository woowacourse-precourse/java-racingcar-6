package racingcar;

import java.lang.String;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class Car {
    String name;
    int forward; //자동차가 몇 번이나 앞으로 갔는지 저장

    Car(String name){
        this.name = name;
        this.forward = 0;
    }
    public void go(){
        if(Randoms.pickNumberInRange(0,9) >= 4)
            this.forward++;
    }
    public void printStatus(){
        System.out.printf("%s : ", this.name);
        for (int i = 0; i < this.forward; i++)
            System.out.print("-");
        System.out.print("\n");
    }
    public void race(){
        this.go();
        this.printStatus();
    }
    public int compare(int winner){
        if (this.forward > winner)
            return this.forward;
        return winner;
    }
}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int winner = 0;
        ArrayList<Car> FinalWinners = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String UserInput = Console.readLine();
        String[] InputTokens = UserInput.split(",");
        ArrayList<Car> Cars = new ArrayList<>();

        System.out.println("시도할 회수는 몇회인가요?");
        int trial = Integer.parseInt(Console.readLine());

        for (String inputToken : InputTokens) {
            if (inputToken.length() > 5)
                throw new IllegalArgumentException("이름은 5글자 이하");
            Cars.add(new Car(inputToken));
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < trial; i++){
            for (int j = 0; j < Cars.size(); j++) {
                Cars.get(j).race();
                winner = Cars.get(j).compare(winner);
            }
            System.out.println();
        }

        for (Car car : Cars) {
            if (car.forward == winner)
                FinalWinners.add(car);
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < FinalWinners.size(); i++){
            System.out.print(FinalWinners.get(i).name);
            if ( (FinalWinners.size() > 1) && (i != FinalWinners.size() -1) )
                System.out.print(", ");
        }
    }
}

package racingcar;
import camp.nextstep.edu.missionutils.*;
class Car{
    String name="";

    Car(String name) {

        this.name = name;

    }

    void move(){

    }


}

class User{
    static int count;


}


public class Application {
    public static void main(String[] args) {

        String inputName="";
        String inputCount="";
        int count;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputName = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        inputCount=Console.readLine();
        count=Integer.parseInt(inputCount);
    }
}

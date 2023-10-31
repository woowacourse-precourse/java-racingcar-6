package racingcar;
import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.ArrayList;

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


        ArrayList<Car> carList= new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        String[] nameArray= inputName.split(",");
        ArrayList<String> nameList= new ArrayList<>(Arrays.asList(nameArray));

        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount=Console.readLine();
        int count=Integer.parseInt(inputCount);


        for(int i=0;i<nameList.size();i++){
            String getName=nameList.get(i);
            carList.add(new Car(getName));
            System.out.println("자동차 이름 출력 : "+carList.get(i).name);
        }
    }
}

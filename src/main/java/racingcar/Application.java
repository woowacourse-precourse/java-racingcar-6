package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.test.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Car{
    String name;
    int moveCount=0;
    StringBuffer moveCountToDash = new StringBuffer();
    Car(String name) {

        this.name = name;

    }
    void carMove(){

        int random=Randoms.pickNumberInRange(0,9);
        if(random>=4){
            this.moveCount++;
            moveCountToDash.append("-");
        }

    }
    void printMoveResult(){
        String dashToString=moveCountToDash.toString();
        System.out.println(name+" : "+dashToString);
    }


}

class UserNameInput{

    static int CarTotal;
    static int CarRacingTotal;
    static ArrayList<String> InputNameToList(){

        String inputName = Console.readLine();
        String[] nameArray= inputName.split(",");
        return new ArrayList<>(Arrays.asList(nameArray));

    }

    static void InputRacingCount(){

        String inputCount = Console.readLine();
        CarRacingTotal = Integer.parseInt(inputCount);

    }



}

class RacingCarTest extends NsTest{

    @Test
    @DisplayName("자동차 게임이 입력값에 따라 잘 구현 되는지 확인")
    public void testValidInput(){
        run("car1,car2,car3,car4,car5,car6,car7","5");

        String expectedOutput = "";
    }



    @Override
    protected void runMain(){

    }




}



public class Application {
    public static void main(String[] args) {


        ArrayList<Car> carList= new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> nameList = UserNameInput.InputNameToList();



        System.out.println("시도할 회수는 몇회인가요?");
        UserNameInput.InputRacingCount();


        for(int i=0;i<nameList.size();i++){

            String getName=nameList.get(i);
            carList.add(new Car(getName));
        }

        System.out.println();
        System.out.println("실행 결과");

        for(int j=0;j<UserNameInput.CarRacingTotal;j++){

            for(int k=0;k<carList.size();k++){

                Car car = carList.get(k);
                car.carMove();
                car.printMoveResult();;

            }
            System.out.println();

        }

        int maxMoveCount=0;

        for(int i=0;i<carList.size();i++){

            Car car = carList.get(i);
            if(car.moveCount>maxMoveCount){

                maxMoveCount=car.moveCount;

            }

        }

        ArrayList<String> winner = new ArrayList<>();

        for(int j=0;j<carList.size();j++){

            Car car = carList.get(j);
            if(car.moveCount==maxMoveCount){

                String name=car.name;
                winner.add(name);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String name : winner) {

            result.append(name).append(", ");

        }

        if (result.length() > 2) {
            result.setLength(result.length() - 2);
        }

        System.out.print("최종 우승자 : "+result);
    }

}

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

    static int maxMoveCount=0;
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

    static void startCarRacing(ArrayList<Car> carList){

        for(int i=0;i<UserNameInput.CarRacingTotal;i++){

            for(Car car : carList){

                car.carMove();
                car.printMoveResult();

            }
            System.out.println();

        }
    }

    static void findMaxCarMoveCount(ArrayList<Car> carList){

        for(Car car : carList){

            if(car.moveCount>Car.maxMoveCount){

                Car.maxMoveCount=car.moveCount;

            }

        }
    }

    static ArrayList<String> makeWinnerList(ArrayList<Car> carList){

        ArrayList<String> winnerList = new ArrayList<>();
        for(Car car : carList){

            if(car.moveCount==Car.maxMoveCount){

                winnerList.add(car.name);

            }

        }
        return winnerList;
    }

}

class UserNameInput{

    static int CarTotal;
    static int CarRacingTotal;
    static int maxMoveCount;
    static ArrayList<String> InputNameToList(){

        String inputName = Console.readLine();
        String[] nameArray= inputName.split(",");
        for(String name : nameArray){

            if(name.length()>5){
                throw new IllegalArgumentException();
            }

        }
        CarTotal = nameArray.length;
        return new ArrayList<>(Arrays.asList(nameArray));

    }

    static void InputRacingCount(){

        String inputCount = Console.readLine();
        CarRacingTotal = Integer.parseInt(inputCount);

    }

    static ArrayList<Car> NameListToCarList(ArrayList<String> nameList){

        ArrayList<Car> carList = new ArrayList<>();
        for(int i=0;i<UserNameInput.CarTotal;i++){

            String getName = nameList.get(i);
            carList.add(new Car(getName));

        }
        return carList;

    }

    static void printWinner(ArrayList<String> winner){

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

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> nameList = UserNameInput.InputNameToList();

        System.out.println("시도할 회수는 몇회인가요?");
        UserNameInput.InputRacingCount();

        ArrayList<Car> carList= UserNameInput.NameListToCarList(nameList);

        System.out.println();
        System.out.println("실행 결과");
        Car.startCarRacing(carList);

        Car.findMaxCarMoveCount(carList);

        ArrayList<String> winner = Car.makeWinnerList(carList);

        UserNameInput.printWinner(winner);



    }

}

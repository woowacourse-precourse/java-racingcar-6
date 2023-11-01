package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.io.ByteArrayInputStream;

import java.util.Arrays;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.test.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Car{
    String name;
    int moveCount=0;
    StringBuffer moveCountToDash = new StringBuffer();

    static int maxMoveCount=0;
    Car(String name) {

        this.name = name;

    }

    static int makeRandomNumberInRange(){

        return Randoms.pickNumberInRange(0,9);
    }
    void carMove(){

        int random= Car.makeRandomNumberInRange();
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

class InputTest {

    @Test
    @DisplayName("사용자 입력이 콤마 단위로 List에 구현 되는지 확인")
    public void testInputNameToList() {

        String input = "car1,car2,car3,car4,car5"; // 입력 데이터
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 입력


        ArrayList<String> nameList = UserNameInput.InputNameToList();


        assertThat(nameList).containsExactly("car1", "car2", "car3", "car4", "car5");
        Console.close();
    }

    @Test
    @DisplayName("0~9 사이의 무작위 값이 추출 되는지 확인")
    public void testMakeRandomNumberInRange(){
        int min = 0;
        int max = 9;

        int random = Car.makeRandomNumberInRange();

        assertTrue(random >= min && random <= max);

    }

    @Test
    @DisplayName("6글자 이상 입력시 예외가 발생하는지 확인")
    public void testInputException() {

        String input = "car1,car12345"; // 입력 데이터
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 입력

        assertThrows(IllegalArgumentException.class, () -> {
            UserNameInput.InputNameToList();

        });
        Console.close();
    }

    @Test
    @DisplayName("우승자 출력 기능이 작동하는지 테스트")
    public void testMakeWinnerList(){
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));


        carList.get(0).moveCount = 3;  // car1의 이동 횟수는 3
        carList.get(1).moveCount = 5;  // car2의 이동 횟수는 5
        carList.get(2).moveCount = 5;  // car3의 이동 횟수도 5
        Car.maxMoveCount=5;

        ArrayList<String> winnerList = Car.makeWinnerList(carList);

        assertThat(winnerList).containsExactly("car2", "car3");

    }
}


class RacingCarTest extends NsTest{

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차가 4 이상일때 전진하는지 확인")
    void 자동차가_4_이상일때_전진하는지_확인(){

        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3", "5");
                    assertThat(output()).contains("car1 : -----", "car2 : -----", "car3 : -----", "최종 우승자 : car1, car2, car3");
                },
                4, 6, 9
        );
        Console.close();

    }

    @Test
    @DisplayName("random값을 제어했을 때 올바른 결과가 나오는지 확인")
    void random_값을_제어했을때_올바른_값이_나오는지_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3", "5");
                    assertThat(output()).contains("car1 : ", "car2 : -----","car3 : -----", "최종 우승자 : car2, car3");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
        Console.close();
    }
    @Override
    protected void runMain(){

        Application.main(new String[]{});

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

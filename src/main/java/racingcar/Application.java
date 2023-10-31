package racingcar;
import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.ArrayList;

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



public class Application {
    public static void main(String[] args) {


        ArrayList<Car> carList= new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        String[] nameArray= inputName.split(",");
        ArrayList<String> nameList= new ArrayList<>(Arrays.asList(nameArray));

        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount=Console.readLine();
        int racingCount=Integer.parseInt(inputCount);


        for(int i=0;i<nameList.size();i++){

            String getName=nameList.get(i);
            carList.add(new Car(getName));
        }

        System.out.println();
        System.out.println("실행 결과");

        for(int j=0;j<racingCount;j++){

            for(int k=0;k<carList.size();k++){

                Car car = carList.get(k);
                car.carMove();
                car.printMoveResult();;

            }
            System.out.println();

        }
    }
}

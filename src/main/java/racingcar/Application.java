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

class InputException{

    static void checkNameLenth(ArrayList<String> nameList){

        for(String Name : nameList){

            if(Name.length()>5){

                throw new IllegalArgumentException();

            }

        }

    }
}


public class Application {
    public static void main(String[] args) {


        ArrayList<Car> carList= new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        String[] nameArray= inputName.split(",");
        ArrayList<String> nameList= new ArrayList<>(Arrays.asList(nameArray));
        InputException.checkNameLenth(nameList);

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

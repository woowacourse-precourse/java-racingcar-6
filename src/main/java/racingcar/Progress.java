package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Rules.*;

//주최자 class
public class Progress {
    static String names;
    static int cycle;
    //자동차 배열리스트
    static ArrayList <Car> carArrayList=new ArrayList<>();

    public Progress(){//기본 생성자
        names=startComment();
        carArrayList=makeCarList();
        cycle =inputNumberComment();

        repeatCircuit();
        System.out.println("최종 우승자 : "+printWinner());

    }

    //레이스를 시작할 때 자동차명들을 입력받기 위한 함수
    static String start_ment="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String startComment(){
        System.out.println(start_ment);

        return readLine();
    }

    //레이스의 횟수를 입력받기 위한 변수
    static String cycle_ment ="시도할 회수는 몇회인가요?";

    //레이스의 횟수를 입력받기 위한 함수
    public static int inputNumberComment(){
        System.out.println(cycle_ment);

        String input_number=readLine();
        if(input_number.equals("")){
            numberNotInputErr();
        }
        if(!isNumeric(input_number)){
            NotNumberErr();
        }
        if(Integer.parseInt(input_number)<=0){
            NotNaturalNumberErr();
        }

        System.out.println("\n실행결과");

        return Integer.parseInt(input_number);
    }


    //정규식을 이용해 정수로만 이루어져있는지 판별
    static boolean isNumeric(String str){
        return str.matches("\\d+");
    }


    //자동차 배열리스트를 생성하는 함수 (+입력에 대한 예외처리)
    public static ArrayList<Car> makeCarList(){
        if(names.equals("")){//자동차 이름이 입력되지 않았을 경우
            nameNotInputErr();
        }
        String[] name_array = names.split(",");
        List<String> names_List =new ArrayList<>();

        for(int i=0;i<name_array.length;i++){
            carArrayList.add(new Car(name_array[i].trim(),0));

            if(names_List.contains(name_array[i].trim())) {//자동차 이름이 중복될 경우
                nameOverlapErr();
            }
            if(name_array[i].trim().length()>5){//자동차 이름의 크기가 5초과일 경우
                nameLengthErr();
            }else if(name_array[i].trim().length()==0){
                nameIsEmpty();
            }

            names_List.add(name_array[i].trim());
        }
        return carArrayList;
    }



    //number만큼의 경주 반복 결과
    public static ArrayList <Car> repeatCircuit(){
        for(long i = 0; i< cycle; i++){
            Circuit circuit=new Circuit(carArrayList);
        }
        return  carArrayList;
    }


    //우승자를 출력하기 위한 함수
    public static String printWinner(){
        int max=0;
        String winners="";

        for(int i = 0; i< carArrayList.size(); i++){
            if(carArrayList.get(i).distance>max){
                max=carArrayList.get(i).distance;
                winners=carArrayList.get(i).name;
            }else if(carArrayList.get(i).distance==max){
                winners+=", "+carArrayList.get(i).name;
            }
        }
        return winners;
    }


}

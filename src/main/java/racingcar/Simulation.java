package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Simulation {

    static ArrayList<RacingCar> racingCarList;

    public void start() {

        createRacingCarList();

        System.out.println("시도할 회수는 몇회인가요?");

        String input = Console.readLine();

        int times = Integer.parseInt(input);

        setRandomRecord(times);

        print(times);

        printWinner();
    }

    private void createRacingCarList() {

        racingCarList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String name = Console.readLine();

        String[] nameArr = name.split(",");

        for (int i = 0; i < nameArr.length; i++) {

            isException(nameArr[i]);

            RacingCar racingCar = new RacingCar(nameArr[i]);

            racingCarList.add(racingCar);
        }

        duplicateNameCheck(racingCarList);
    }

    private void isException(String name){

        nameLengthCheck(name);
        nameViolationCheck(name);
    }

    private void nameLengthCheck(String name){

        if(name.length() < 1 || name.length() > 5) {

            throw new IllegalArgumentException("입력 가능한 자동차 이름 길이를 위반하였습니다.");
        }
    }

    private void nameViolationCheck(String name){

        String REGEX = "[a-z|A-z]*$";

        if(!name.matches(REGEX)){

            throw new IllegalArgumentException("자동차의 이름에는 영문만 사용 가능합니다.");
        }
    }

    private void duplicateNameCheck(ArrayList<RacingCar> racingCarList){

        Set<String> set = new HashSet<>();

        for(RacingCar car : racingCarList){

            set.add(car.getName());
        }

        if(set.size() != racingCarList.size()){

            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private void setRandomRecord(int times) {

        for (int i = 0; i < times; i++) {

            for (int j = 0; j < racingCarList.size(); j++) {

                int record = Randoms.pickNumberInRange(1, 9) - 3;

                if (record < 0) record = 0;

                racingCarList.get(j).saveRecord(record);
                racingCarList.get(j).calculateTotalRecord(record);
            }
        }
    }

    private void print(int times) {

        System.out.println("실행 결과");

        for(int i=0 ; i<times; i++) {
            for (int j=0; j<racingCarList.size(); j++) {

                System.out.print(racingCarList.get(j).getName() + " : ");

                int count = racingCarList.get(j).getRecords().get(i);

                for (int k = 0; k < count; k++) {

                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private void printWinner(){

        Collections.sort(racingCarList,
                (a, b) -> b.getTotalRecord() - a.getTotalRecord());

        String s = "최종 우승자 : "+racingCarList.get(0).getName();

        int max = racingCarList.get(0).getTotalRecord();

        for (int i=1; i<racingCarList.size(); i++){

            if(max != racingCarList.get(i).getTotalRecord()) break;

            s += ", "+racingCarList.get(i).getName();
        }

        System.out.println(s);
    }
}

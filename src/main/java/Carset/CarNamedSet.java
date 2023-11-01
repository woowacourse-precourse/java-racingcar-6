package Carset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import validation.Validation;

public class CarNamedSet {
    private List<String> CarNamed;
    private Validation validation;

    public CarNamedSet() {
    	validation = new Validation();
        CarSetting();
    }

    public List<String> NameSetting() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String members = Console.readLine();
        validation.validateCarNamesFormat(members);
        // 쉼표(,)로 구분된 이름을 리스트에 추가
        CarNamed = Arrays.asList(members.split(","));
        
        return CarNamed;
    }

    public void CarSetting() {
        CarNamed = new ArrayList<>();
    }

    public List<String> GetCarMembers() {
        return CarNamed;
    }
    
   
}

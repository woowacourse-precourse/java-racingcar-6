package inAndOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Input {
    private Scanner scanner;
    private List<String> carNames;
    private int count;
    private IOValidator validator;
    public Input(Scanner scanner) {
        this.scanner = scanner;
        this.carNames = new ArrayList<>();
        this.count = 0;
        this.validator = new IOValidator();
    }

    public void setInput() {
        System.out.println("입력해주세요");
        //validation
        String names = validator.validateCarNames(scanner.nextLine());
        // 자동차 이름 get
        addCarNames(names);
        // 시도 횟수 validation get
        System.out.println("회수 입력");
        this.count = validator.validateCount(scanner.nextLine());
    }

    private void addCarNames(String names) {
        String[] split = names.split(",");
        for (String name : split) {
            carNames.add(name);
        }
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    public int getCount() {
        return this.count;
    }
}

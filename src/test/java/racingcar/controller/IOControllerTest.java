package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class IOControllerTest {
    @Test
    public void printName(){
        List<String> names = new ArrayList<>(Arrays.asList("apple","kris"));
        System.out.println("최종 우승자 : "+names.toString().replace("]","").replace("[",""));
    }

}
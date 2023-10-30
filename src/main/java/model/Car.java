package model;

import util.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : model
 * fileName       : Car
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class Car {

    private static final int MOVING_DISTANCE = 1;
    private static final int STANDARD_VALUE = 4;
    private static final int INIT_POSITION = 0;
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 0;

    private String name;
    private int position;

    public String getName(){
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public Car(String name){
        validate(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    private void validate(String name) {
        validateNotEmpty(name);
        validateLength(name);
    }

    private void validateNotEmpty(String name) {
        if (name == null || name.isBlank() || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH || name.length() <= MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void goOrStop(int random) {
        if (random >= STANDARD_VALUE) {
            move(MOVING_DISTANCE);
        }
    }

    private void move(int distance){
        this.position += distance;
    }
}

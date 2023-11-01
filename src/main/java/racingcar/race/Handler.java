package racingcar.race;

public interface Handler<T,R>{
     R execute(T t);
}

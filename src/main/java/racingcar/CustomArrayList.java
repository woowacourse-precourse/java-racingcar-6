package racingcar;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomArrayList<E> extends ArrayList<E> {

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            E e = it.next();
            sb.append(e);
        }
        return sb.toString();
    }
}
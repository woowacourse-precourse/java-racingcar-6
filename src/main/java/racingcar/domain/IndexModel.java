package racingcar.domain;

/*
이 클래스를 상속한 클래스의 객체는 Repository에 순차적인 index를 가지는 방식으로 저장될 수 있습니다.
 */
public abstract class IndexModel {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

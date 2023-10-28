# 테스트 코드를 먼저 작성해보자
이전에는 "선 기능 구현, 후 테스트 코드 작성" 순서로 개발을 진행했고 이런 순서가 당연한 생각이었다. 없는 걸 어떻게 테스트하냐는 논리였다.
이전 주차에서 TDD에 대해 관심이 생겨서 TDD에 대한 내용을 학습했다.
TDD 매커니즘에 대해 완벽하게 배웠다고 자신하지는 못하지만 대략 어떤 느낌인지 감을 잡았다.

TDD의 가장 중요한 아이디어는
1. 먼저 요구사항을 반영하는 테스트 코드를 작성하고
2. 그 테스트 코드를 만족시키는 코드를 작성한다.
3. 성능, 재사용성, 가독성이 좋은 코드를 만들기 위해 리팩토링한다.

## 적용
1. 자동차 이름이 5자를 초과하면 예외 처리가 되는 기능의 테스트 코드를 작성했다.

```
@Test  
void 자동차_이름_5자초과_예외처리_테스트() {  
    assertThatThrownBy(() -> new Car("송민준입니다")).isInstanceOf(IllegalArgumentException.class);  
}
```

2. 이를 만족하는 코드를 만들었다.

```
public class Car {
	public Car(String carName) {  
	    this.carName = carName;  
	    this.movingDistance = 0;  
	}
	private void validateCarNameLengthExceed(String carName) {  
	    if (carName.length() > 5) {  
	        throw new IllegalArgumentException("자동차의 이름은 5자를 넘어갈 수 없습니다.");  
	    }  
	}
```

3. 여기서 자동차의 이름을 클래스로 만들어 확장성이 높아지도록 리팩토링을 수행했다.

```
public class CarName {  
    String carName;  
    public CarName(String carName) {  
        validateCarNameLengthExceed(carName);  
        validateCarNameLengthZero(carName);  
        this.carName = carName;  
    }  
  
    private void validateCarNameLengthExceed(String carName) {  
        if (carName.length() > 5) {  
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘어갈 수 없습니다.");  
        }  
    }
```
![[Pasted image 20231027010059.png]]

이렇게 TDD 방식대로 테스트 코드를 먼저 작성해보니까 이전에는 내가 싸질러(?) 놓은 코드들에 대한 테스트 코드를 작성하는게 귀찮았던 반면 테스트 코드를 먼저 작성하니까 테스트를 성공시키려고 노력하는 나를 발견했다. 그리고 기능별로 테스트 코드를 작성하고 코딩을 시작하니까 여러 기능이 하나의 메서드에서 사용되는 일이 거의 없었다. 단위 테스트를 진행하기 위해 여러 기능이 쪼개지게 되므로 클래스의 분리가 일어나고 재사용성, 가독성이 좋아지는 결과를 볼 수 있었다.
또한 테스트를 위해 private를 public으로 바꿔야할까 고민한 적도 많았는데 이를 고민하는 이유는 보통 설계를 잘못해서 라고 한다. 하지만 TDD 방식으로 개발을 진행하면 애초에 테스트를 짜고 시작하니 우리가 만들어야할 기능은 public으로 만들 수 밖에 없다는 장점이다. 은연중에 설계에도 도움이 되는 느낌을 받았다.  
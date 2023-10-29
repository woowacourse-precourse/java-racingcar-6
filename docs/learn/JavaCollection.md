# 배열 대신 Java Collection을 사용한다
1주차 피드팩에서 "배열 대신 Java Collection을 사용한다"라는 내용의 피드백이 있었다. 피드백을 받고 1주차 때도 컬렉션을 사용했지만 2주차에는 더 적극적으로 활용을 했다.

## 사례1: List.sort()
그 사례로 최종 우승자를 가려내는 기능을 구현한 것을 들 수 있다.

이는 원래 구현할 기능 목록이다.

```
- [ ] 최종 우승자를 판정하는 기능 구현  
  - [ ] 자동차별로 이동 거리 확인  
    - [ ] 최고 이동 거리면   
	  - [ ] 최고 이동거리 갱신  
      - [ ] 우승자 리스트 clear하고 자동차 추가
```

이를 구현하기 위해서는 아래와 같이 코드를 짜야했을 것이다.

```
int maxDistance = 0; 
List<Car> winnerList = new ArrayList<>();
for(Car car : cars){
	if(car.distance > maxDistance) {
		maxDistance = car.distance;
		winnerList = new ArrayList<>();
		winnerList.add(car);
	}
	else if(car.distance == car.distance){
		winnerList.add(car);
	}
}
```

충분히 잘 돌아갈 수 있는 코드지만 if else 문이 있기 때문에 가독성이 떨어질 수 있는 코드다.
다행히도 List 컬렉션은 `sort()`라는 좋은 기능이 존재한다. `sort()`는 정해진 규칙에 위해서 컬렉션 안의 요소들을 정렬시킨다.

`sort`를 사용했기 때문에 변경된 기능 목록이다.

```
- [ ] 최종 우승자를 판정하는 기능 구현  
  - [ ] 자동차 이동거리 순으로 정렬  
  - [ ] 가장 첫번째 자동차와 모든 자동차의 이동거리를 비교  
    - [ ] 같은 이동 거리면 우승자 리스트에 추가
```

아래는 `Comparable`을 구현하고 `compareTo`를 오버라이딩해서 정렬할 때 필요한 규칙을 정하는 Car 클래스다.

```
public class Car implements Comparable<Car>{  
    private CarName carName;  
    private int movingDistance;
    ...
    @Override  
	public int compareTo(Car o) {
		return o.movingDistance - this.movingDistance; 
	}
```

```
List<Car> winnerList = new ArrayList<>();  
cars.sort(Comparator.reverseOrder());  
Car firstWinner = cars.get(0);  
int carIndex = 0;  
while (carIndex < cars.size() && cars.get(carIndex).compareTo(firstWinner) == 0) {  
    winners.add(cars.get(carIndex));  
    carIndex++;  
}
```

## 사례2: List.contains()
같은 값이 있는지 알려주는 `List.contains` 메서드다.

```
List<String> strList = new ArrayList<>();
strList.add("MJ");
strList.contains("MJ"); //true

List<Integer> intList = new ArrayList<>();
intList.add(123);
intList.contains(123); //true
```

문자열, 숫자와 같은 기본 자료형은 쉽게 리스트에 포함되어 있는지 알 수 있다.
하지만 우리가 정의하는 클래스는 다르다.
List 클래스는 contains를 할 때 "어떤 방식으로 같음을 증명"하는지 알아야 contains를 사용할 수 있다.

따라서 `equals()`를 오버라이딩 해줘야한다.

```
private void validateDuplicatedCarName(Car car) {  
    if (cars.contains(car)) {  
        throw new IllegalArgumentException("차 이름이 중복되었습니다.");  
    }  
}
```

다음은 내 프로젝트에서 중복된 자동차 이름을 예외처리하는 메서드다.
물론 getter를 사용해 가져와, 같은지 비교할 수 있고 가능할 것이다. 하지만 가독성도 떨어지고 캡슐화를 망가뜨리는 원인이 될 것이다. 따라서 `List.contains()`를 활용하기로 했다. 활용하기 위해서는 Car의 `equals`를 오버라이딩 해야한다.

```
public class Car {
...
	@Override  
	public boolean equals(Object obj) {  
	    String opponentCarName = ((Car) obj).carName;  
	    return opponentCarName.equals(carName);  
	}
}
```

업캐스팅한 뒤에 상대 문자열과 자신의 문자열을 비교해서 같은 지 확인한다. 이로써 `List.contains()`를 활용할 수 있게 되었다.

결과적으로 자바 컬렉션의 도움을 받고 기능을 더욱 쉽게 구현할 수 있었다.  기능을 구현할 때마다 자바 컬렉션의 사용을 염두해둬야겠다는 생각이 들었다. sort 나 contains 와 같이 좋은 메서드가 있을 수 있기 때문이다.  자바 컬렉션은 우리가 필요없는 코딩을 하지 않도록 도와준다. 
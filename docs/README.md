# 🚗 자동차 경주
2주차 과제 구현을 위한 기능 명세서

## 💡  기능 요구사항 목록

### ✅ 자동차 관리

- 자동차 생성
  - 입력받은 이름을 쉼표 기준으로 parsing한다.
  - 입력받은 이름의 유효성을 검사한다.
  - 각 이름을 가지는 자동차 객체를 생성한다.
- 자동차 이동
  - 0~9 사이의 난수를 생성한 뒤 4 이상 일때 전진한다.
- 자동차 전진 횟수
  - 저장된 총 이동 횟수를 조회할 수 있다.

### ✅ 게임 관리

- 게임 실행
  - 이동 횟수를 입력받는다.
  - 모든 자동차에 대한 이동 메소드를 횟수만큼 반복한다.

- 게임 결과 출력
  - 자동차의 이동횟수만큼 '-'를 출력한다.
  - 자동차 이동횟수의 최대값을 가지는 이름들을 출력한다.

## 💡  기능 구현 목록
### GameController
| Method  | Description                                      |
|:-------:|--------------------------------------------------|
|   run   | 프로그램 flow를 관리한다. <br> model과 view 간의 상호작용을 담당한다. |
|play| 모든 자동차 객체에 대해 playGame을 호출한다.|

### GameService
|   Method   | Description                                             |
|:----------:|---------------------------------------------------------|
| createCars | 넘겨받은 carNames의 각 원소를 save에 인자로 넘겨 호출한다.                 | 
| nameCheck  | 넘겨받은 carNames의 각 원소가 5자 이하인 지 검사한다.                     |
|  playGame  | 넘겨받은 idx에 해당하는 car 객체에 대해 carForward를 호출하고 반환값을 다시 반환한다 |
| resultGame | findAllMaxForward를 호출하고 그 반환값을 다시 반환한다.                 |

### Car
|   Method   | Description                      |
|:----------:|----------------------------------|
| setForward | 넘겨받은 integer를 객체의 forward로 설정한다. |
|  getName   | 객체의 name을 return 한다.             |
| getForward | 객체의 forward를 return한다.           |

### CarRepository
|      Method       | Description                                          |
|:-----------------:|------------------------------------------------------|
|       save        | 넘겨받은 string을 이름으로 가지는 car 객체를 생성한다                   |
|    carForward     | 넘겨받은 randomNumber에 따라 forward 값을 변경하고 car를 return한다. |
| findAllMaxForward | 모든 car 객체들중 forward가 최대값인 객체들의 이름을 List 형태로 return한다 |
|    findByName     | 넘겨받은 string을 name의 값으로 가지는 car 객체를 return한다.         |

## InputView
|    Method    | Description                                                             |
|:------------:|-------------------------------------------------------------------------|
|  inputName   | 이름에 해당하는 문자열을 입력받고 ,를 기준으로 parsing해 list 형태로 return한다                   |
| inputAttempt | 시도 횟수에 해당하는 숫자를 입력받는다.<br> 숫자가 아닐 경우 IllegalArgumentException을 throw한다. |

## OutputView
|    Method     | Description                                             |
|:-------------:|---------------------------------------------------------|
| outputResult  | "실행 결과"라는 문자열을 출력한다.                                    |
| outputForward | 넘겨받은 car 객체의 forward값을 양식에 맞춰 출력한다                      |
| outputWinner  | 넘겨받은 우승 자동차들의 이름(List<String>)을 양식에 맞춰 출력한다.            |
|  printComma   | 마지막 순서의 원소인지 검사하는 valueForCheck에 따라 자동차 이름 뒤에 , 붙여 출력한다 |

## ⚒️ 1차 구현의 개선할 내용

- MVC 패턴의 개선
  - 현재 Repository에 view가 존재함
  - view와 repository는 서로 의존할 수 없다!
  - 이러한 의존을 controller로 옮기는 작업이 필요
 💡  Controller를 통해 view와 model 간의 통신을 하자.
- 테스트 코드 작성
  - 메소드 단의 테스트 코드를 작성해야함
  - 현재 의존관계가 이상해서 제대로 구현하기 어려움
  - 역시나 의존관계를 재정립하자

## ✅ 추가한 기능 테스트 목록
- ❔ 우승자가 중복일 때 정상적으로 출력하는가?
- ❔ 반복 횟수가 숫자가 아닐 때 예외를 처리하는가?
- ❔ 많은 반복 횟수에서 각 자동차의 현재 위치를 정상적으로 출력하는가?


##  💡 프로그래밍 요구 사항
- indent depth가 3이 넘지 않는다.
- 3항 연산자 사용하지 않는다.
- 메소드는 최대한 작게 만든다.
- 테스트 코드를 작성해 정상 작동 유효성을 검사한다.

## 💡  적용해 볼 내용
- MVC 패턴을 적용해 비즈니스 로직의 유지보수를 쉽게 한다.
  - 한 파일에 몰아 넣으니 유지보수하기 너무 어려웠음.
- 이름을 축약하지 않는다.
- 필요하다면 주석을 작성한다.
- 수정사항이 생기면 즉시 커밋하자.
- 커밋 메시지를 가독성 있게 작성하자.
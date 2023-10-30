# 미션 - 자동차 경주

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- [ ] 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- [ ] **기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다**

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
  - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

## 🚀 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 주어진 횟수
  - n대의 자동차
  - 자동차는 전진한다 혹은 멈춘다 
  
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - 출력시 자동차의 전진 회수와 이름 모두 출력해야 한다
  - 자동차는 필드로 이름이 존재한다
  - 자동차는 전진 회수가 존재한다 

- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 자동차 이름을 입력 받을 때 기준은 ','
  - 이름은 5자 이하만 가능하다
    - null, empty
    - 범위에서 벗어난 경우 
    - 이름인데 숫자로 입력된 경우(Regex 활용)
    - 중복된 이름이 존재하는 경우 

- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 총 이동 회수 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - 전진 조건은 무작위 수를 기준으로 진행된다
  - 4이상인 경우에만 전진한다
  - 4보다 작은 경우 멈춘다 

- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - 게임이 완료되면 우승자를 출력한다
  - 단수, 복수의 우승자 모두 가능하다 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
  - 복수의 우승자인 경우 쉼표를 이용해서 구분한다 

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
  - 예외 처리는 IllegalArgumentException을 발생시킨다
  - 어플리케이션이 종료되도록 한다

## Skeleton Code - Model
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - [x] Car - 자동차 
    - [x] 자동차는 전진할 수 있다
    - ~~자동차는 멈출 수 있다~~
  - [x] RacingCars.List<Car> - n대의 자동차

- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다
  - [x] 자동차는 이름 특성을 가지고 있다
    - [x] 자동차는 Name을 필드로 가진다 in Car.class
  - [x] 자동차는 움직인 횟수 특성을 가지고 있다
  - [ ] 출력시 자동차 이름도 같이 출력해야 한다

- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다 
  - [ ] 자동차 이름을 입력 받을 때 기준은 ',' (String.split(",")) 
  - [ ] 이름은 조건을 만족해야 한다 
    - [ ] **예외** null, empty (isNullOrEmtpy())
    - [ ] **예외** 이름인데 숫자로 입력된 경우(Regex 활용) (hasWrongCharacters) - 영문 이름으로 표현
    - [x] **예외** 범위에서 벗어난 경우 (isOverTheLength) - 6자, 7자 ,, etc in Name.class
    - [x] **예외** 이름이 중복된 경우 - "pobi,pobi,..." in Name.class
    - [ ] **예외 처리** throw new IllegalArgumentException

- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - [x] 전진 조건은 무작위 수를 기준으로 진행된다
  - [x] 4이상인 경우에만 전진한다
  - [x] 4보다 작은 경우 멈춘다 (=전진하지 않는다) 

- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다 
  - [x] 입력받은 이동 횟수 - RoundTotal

- [ ] 라운드 별 자동차들의 전진 횟수를 주어진 형식에 맞게 출력한다
  - [ ] 등록되어 있는 자동차 전체를 출력한다
  - [ ] 전진 횟수를 '-'로 표현한다
    - [ ] "이름 : --" 형태로 출력한다  
    - [ ] 전진 횟수만큼 '-'를 연속적으로 출력한다 
    
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다 
  - [ ] 전체 라운드 만큼 진행한 경우 우승자를 출력한다 
  - [ ] 단수, 복수의 우승자 모두 가능하다
    - 단수의 우승자는 이름을 출력한다  
    - 복수의 우승자인 경우 쉼표를 이용해서 이름을 구분한다
    
## Controller flow
- 자동차 입력을 입력 받아 RacingCars를 형성한다 registerCarNames()
  - [x] OutputView - "경주할 자동차 이름을 입력하세요.(이름은..." 출력
  - [x] inputView - 문자열을 입력 받고, 해당 문자열을 Controller에게 반환한다 
    - [x] **예외** 문자열이 null 혹은 length()가 0 인 경우 
    - [x] **예외** 영문자로 구성된 이름이 아닌 경우 
    - [x] **예외 처리** throw new IllegalArgumentException 
  - 받은 문자열을 StringToCarList을 활용하여 List<Car>로 변환한다 ''
    - [ ] StringToCarList - 문자열을 ',' 단위로 구분하고 List<Car>을 구성한다 
      - [ ] **예외** 5글자가 넘어가는 이름
      - [ ] **예외 처리** throw new IllegalArgumentException
    - [ ] 형성한 List<Car>를 RacingCars 생성자 인자로 전달한다
      - [ ] **예외** 이름이 중복된 경우
      - [ ] **예외 처리** throw new IllegalArgumentException

- 진행할 라운드 횟수를 입력받아 Round를 형성한다 registerRoundTotal()
  - [ ] OutputView - "시도할 회수는 몇회인가요?" 출력
  - [ ] inputView - 문자열을 입력 받고, 해당 문자열을 Controller에게 반환한다
    - [ ] **예외** 문자열이 숫자가 아닌 경우
    - [ ] **예외** 문자열이 '0'으로 시작하는 경우 ex) 015
    - [ ] **예외 처리** throw new IllegalArgumentException
  - [ ] Controller - 받은 문자열을 StringToRound를 활용하여 Round를 형성한다
    - [ ] **예외** 문자열이 범위를 벗어난 경우 ex) 0보다 이하 or Integer.MAX_VALUE 보다 큰 경우
    - [ ] **예외 처리** throw new IllegalArgumentException

- 라운드 별 RacingCars의 distance 상태를 표현한다 displayRacingStatus()
  - [ ] OutputView - "실행 결과"를 우선 출력하고 규칙에 따라 각 Car의 이름과 distance를 출력한다
    - [ ] model에서 RacingCars, Round 정보를 조회한다 
    - [ ] Round의 round 회수 만큼 동일한 규칙에 맞게 출력한다 (ex $name : --)
      - [ ] round마다 RacingCars를 구성하는 Car는 랜덤으로 생성되는 수를 전달받아 전진 여부를 결정한다
      - [ ] RacingCars를 구성하는 Car의 이름을 출력한다
      - [ ] Car의 distance 만큼 '-'를 반복해서 출력한다 
      - [ ] round 종료될 때까지 위의 순서를 반복한다 

- 라운드를 마치고 최종 우승자를 출력한다 displayWinner()
  - [ ] OutputView : "최종 우승자 :" 를 출력한다
    - [ ] : model로 부터 RacingCars 객체를 조회한다
    - [ ] : RacingCars의 우승자를 확인한다
    - [ ] : 우승자를 출력한다
      - [ ] : 혼자인 경우 이름을 출력한다
      - [ ] : 복수인 경우 이름 사이 ',' 를 출력한다
    
## 🎯 프로그래밍 요구 사항

- [ ] JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- [ ]JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## ✏️ 과제 진행 요구 사항

- [ ] 미션은 [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
- [ ] **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [ ] **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- [ ] 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://githu
- b.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

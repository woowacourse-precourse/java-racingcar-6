### Racer 클래스 

---
#### 멤버 변수

--- 
- static int moveCount
  - 움직일 횟수를 저장하는 정적 멤버 변수
  - 움직이는 횟수는 공통적으로 사용되기 때문에 정적 멤버로 선언함.

- String name
  - 운전자의 이름을 저장하는 멤버 변수

- StringBuilder score
  - 운전자의 성적을 기록하는 멤버 변수  

#### 멤버 메소드

---
##### 생성자 메소드
- name : Racer
- parameters : String name
- return : 
- error : 문자열이 5자 이상이면 `IllegalArgumentException` 발생
- description
  - 5자 이하의 문자열을 받아 해당 문자열을 이름으로 가지는 새 레이서를 생성하는 메소드
  - `score`는 새 `StringBuilder`로 초기화한다.

##### 레이서를 움직이는 메소드
- name : move
- parameter : 
- return : void
- error : 
- description 
  - Game 클래스에서 생성한 무작위 값을 받아서 움직이는 함수
  - 무작위 값이 4이상이라면 `score`에 `-`를 `append`한다.

### Game 클래스

---
- moveCount를 세팅해주기
- 무작위 값 추출하기


### Util 클래스

---
문자열 관련해서 도와주는 클래스
- 입력받은 문자열을 `,`로 구분해서 이름의 배열로 만들어주기
- 실행 결과 출력해주기
- 우승자 출력해주기
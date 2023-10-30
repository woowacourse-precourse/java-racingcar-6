## 구현 기능 목록

### **1. 자동차 입력 받기**

1. 질문: "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
2. `.split(",")`을 이용해 배열(Array)에 분리해서 저장
    - 자동차 이름 저장하는 배열의 이름:`carNames`
3. 검증
    - 2대 이상의 자동차 입력
    - 자동차의 이름이 5자 이하인지 검사

### **2. 시도 횟수 입력**

1. 질문: "시도할 회수는 몇회인가요?"
2. `int n`에 저장
3. 검증
    - 정수 입력 (`Integer.parseInt()`시도)
    - 양수 (n >= 1)

### **3. 앞으로 간 거리를 저장할 Array 생성**

- 배열 이름:`movedDistance`
- 배열의 길이:`carnames.length`
- 저장할 자료형: String
- `Arrays.fill(movedDistance, "");`사용해 초기값 공백으로 설정
- `movedDistance[i] += "-";`사용해서 간 거리 더해줄 것임

### **4. 한줄 띄어쓰기**

- `System.out.println();`
- `System.out.println("실행 결과")`

### **5. For문을 사용해 n회 게임 반복 -> i**

1. 난수 생성
    - 숫자 저장할 배열 만들기
        - 배열 이름:`howFar`
        - 배열의 길이:`carnames.length`
        - 저장할 자료형: int
    - 각 자동차마다`pickNumberInRange(0, 9)`사용해서 난수 생성
    - 배열에 저장
2. 난수가 4이상일 때 "-" 추가
    - `howFar[i] >= 4`일 때
        - `movedDistance[i] += "-";`
3. 출력
    - 반복: for문 이용해`carnames.length`번 반복해 아래 문장 출력
        - `carnames[j] + " : " + howFar[j]`
    - 마지막에 띄어쓰기:`System.out.println();`

### **6. 최종 우승자 출력**

1. `int max = 0`선언,`winningCandidate`라는 ArrayList 생성 (자료형: String)
2. `movedDistance`의 각 인덱스 돌면서 다음 작업 수행
    - `max`에는 거리의 max값이, 그 이후의 인덱스에는 max만큼 간 차의 이름 저장
    - `max`가 갱신될 때는 `winningCandidate`을 초기화 한 다음 빈 ArrayList에 차 이름 추가
3. 출력
    - `StringBuilder winners` 선언
    - for문 돌면서 `winners`에 `" " + winningCandidate[j] + ","` 추가
    - `winners.deleteCharAt(winners.length() - 1);`로 마지막 문자(쉼표) 지우기
    - `System.out.print("최종 우승자 :" + sb);`

## 커밋 메시지 <scope>
- 변경 파일 의미
- gameMethods: /GameMethods.java, /GameMethodsTest.java
- validation: /Validation.java, /ValidationTest.java
- application: /Application.java
- readme: /docs/README.md
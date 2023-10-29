# 구현할 기능 목록 정리

- 체크리스트
    - [ ]  git clone & Checkout branch
    - [ ]  자바 버전 17로 변경
- 기능 요구 사항
    - [ ]  경주할 자동차 이름 입력받기
    - [ ]  입력받은 이름을 쉼표로 구분
    - [ ]  시도할 횟수 입력받기
    - [ ]  잘못된 값 입력 시 프로그램 종료
    - [ ]  실행 결과 출력 ("자동차 이름 : ")
    - [ ]  각 자동차에 0~9 사이 무작위 정수 부여하는 알고리즘
    - [ ]  4 이상일 경우 "-" 추가
    - [ ]  입력받은 시도할 횟수만큼 반복
    - [ ]  자동차들의 "-" 개수 비교
    - [ ]  최종 우승자 출력
- 프로그래밍 요구 사항
    - [ ]  파일의 시작점 : `Application`의 `main()`
    - [ ]  `Randoms` 및 `Console` API 사용
    - [ ]  `System.exit()` 호출하지 않고 프로그램 종료
    - [ ]  intent는 2까지 허용
    - [ ]  한 가지 일만 하도록 함수 분리
    - [ ]  Unit 5와 AssertJ를 이용하여 테스트 코드로 확인
- 과제 진행 요구 사항
    - [ ]  `docs/README.md`에 구현할 기능 목록 정리
    

### 클래스 / 메서드 정리

1. Application
    - main()
    : 애플리케이션 시작 제어
    - printStart()
    : 게임 시작 문구 출력
    - printResult()
    : 경기 결과 출력
2. UserNum
    - getCars()
    : 자동차 이름 입력받기
    - getTryNum()
    : 시도할 횟수 입력받기
3. RandomNum
    - genRandomNum()
    : 각 자동차마다 0~9 사이 무작위 정수 지정
4. Racing
    - addHyphen()
    : 무작위 정수가 4 이상일 경우 "-" 추가
5. Judgement
    - judgement()
    : 우승자 판별

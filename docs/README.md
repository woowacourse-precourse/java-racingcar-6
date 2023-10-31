# 구현할 기능
1. 자동차 객체 도메인 생성
    - 필드 값
      - 이름 (String)
        생성할 때 입력받아 초기화
      - 위치 (int)
        기본값 0
    - 메소드
      - randomDrive() 메소드
        - 0~9사이 무작위 값을 구하고 4 이상이면 필드 값 중 위치 값을 +1
        - 그 후 결과로 객체의 위치 값을 return
2. 자동차 이름 입력 컨트롤러 
   - 입력된 String 값을 ','를 기준으로 split 후 trim하고 배열로 변환
     - 입력 값 유효성 검사
        >> 1자 이상 5자 이하
   - 객체 생성 후 CarsDto 객체 반환
3. RaceGameService 객체 구현
   - roundStart() 메소드
      - CarsDto를 매개변수로 받아 각각 Car.randomDrive()를 실행
      - 결과를 다시 CarsDto로 return
4. 시도 횟수 입력 컨트롤러
   - CarsDto와 사용자 read를 입력 받음 
   - 사용자로부터 입력된 String 값을 int로 변환
     - 유효성 검사
       1. 0을 허용 X
       2. [0-9]+ 로 처리
   - 아래의 행동을 입력된 만큼 반복
     - RaceGameService.roundStart() 실행
     - 결과는 dto를 통해 실행결과 표기
   - 횟수가 끝난 뒤 최종 우승자를 출력
5. 기타 출력 설정
   
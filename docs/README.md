# 기능 목록

1. 자동차 경주 게임 시작 및 자동차 이름 입력 문구 출력
2. 자동차 이름 입력
    1) 입력 유효성 체크
        * 5글자 이하
        * 쉼표로 구분
        * 잘못 입력 시: IllegalArgumentException 발생 후 애플리케이션 종료
    2) 입력받은 값은 List로 저장
3. 이동 횟수 입력
   1) 입력 유효성 체크
        * 숫자
        * 잘못 입력 시: IllegalArgumentException 발생 후 애플리케이션 종료
4. 실행 결과 출력
5. 최종 우승자 출력

✅ 랜덤 값 생성 : camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()

✅ 사용자 입력 : camp.nextstep.edu.missionutils.Console.readLine()
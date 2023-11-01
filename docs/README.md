# ✏️ 기능 구현 목록

## 🌏 목차

- ### [UserInput](#-userinput)
- ### [Output](#-output)
- ### [Race Progress](#-raceprogress)
- ### [Validate](#-validate)

---

## 👍 UserInput

- ## View.ConsolePrint.java

    - ### 자동차 이름 입력

        - ### readCars()

    - ### 시도 횟수 입력

        - ### readTryNum()

## 👍 Output

- ## View.ConsolePrint.java

    - ### 레이스 경주 결과 출력

        - ### printRace()

    - ### 공동 우승자 모두 출력

        - ### printWinner()

## 👍 Race Progress

- ## Controller.RaceController.java

    - ### 레이스를 시작하고 진행

        - ### start()

    - ### 시도 횟수 만큼 자동차들 전진

        - ### race()

    - ### 조건에 따라 전진 여부 결정

        - ### move()

    - ### 이동한 거리순으로 정렬해서 우승자 찾기

        - ### findWinner()

## 👍 Validate

- ## Model

    - ### 자동차이름 입력 유효성검사 -> Model.Car.java and Model.CarList.java

        - ### 서로 다른 이름만 입력 했는지 체크
            - ### validateSameName()
        - ### 입력 이름을 다섯글자 이하로만 했는지 체크
            - ### validateNameLength()
        - ### 입력 이름이 비어있는 string이 아닌 오로지 1글자 이상의 이름인지 체크
            - ### validateEmpty()

    - ### 시도횟수입력 유효성검사 -> Model.TryNumber.java

        - ### 입력한 시도횟수가 오로지 양의정수인지 체크
            - ### validatePositive()
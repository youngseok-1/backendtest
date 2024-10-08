음료 관리 시스템 (Drink Management System)

이 프로젝트는 다양한 음료를 관리하고, 판매 정보를 기록하는 백엔드 시스템입니다. 음료의 기본 정보, 판매 여부, 제조사 등을 관리하고 데이터베이스에 연동하여 CRUD 기능을 제공합니다.

목차

	1.	프로젝트 개요
	2.	데이터베이스 구조
	3.	기능 설명
    4.	설치 및 실행

프로젝트 개요

음료 관리 시스템은 음료를 등록하고, 수정하고, 삭제하며, 판매 여부를 관리하는 기능을 제공합니다. 이 시스템을 통해 제조사별 음료, 종류, 가격, 유통기한, 재고 등을 손쉽게 관리할 수 있습니다. 


데이터베이스 구조

테이블 구성

	•	COMPANY: 음료 제조사 정보를 저장하는 테이블
	•	COM_CODE: 제조사 코드 (Primary Key)
	•	COM_NAME: 제조사 이름
	•	TYPE: 음료의 종류 정보를 저장하는 테이블
	•	TYPE_CODE: 종류 코드 (Primary Key)
	•	TYPE_NAME: 종류 이름
	•	DRINK: 음료의 상세 정보를 저장하는 테이블
	•	DRK_CODE: 음료 코드 (Primary Key)
	•	DRK_NAME: 음료 이름
	•	PRICE: 가격 (정수형)
	•	IS_ZERO: 제로 여부 (Boolean)
	•	COM_CODE: 제조사 코드 (Foreign Key)
	•	TYPE_CODE: 종류 코드 (Foreign Key)
	•	EXP_DATE: 유통기한 (DATE)
	•	DRK_SIZE: 음료 용량
	•	SELL: 판매 정보를 저장하는 테이블
	•	SELL_CODE: 판매 코드 (Primary Key)
	•	IS_AVA: 재고 여부 (Boolean)
	•	DRK_CODE: 음료 코드 (Foreign Key)

기능 설명

1. 음료 추가 기능

   •	새로운 음료 정보를 추가할 수 있습니다.
   •	음료 코드, 이름, 가격, 제조사, 종류, 유통기한 등을 입력받아 추가합니다.

2. 음료 삭제 기능

   •	특정 음료 코드를 입력받아 데이터베이스에서 음료 정보를 삭제합니다.

3. 음료 수정 기능

   •	특정 음료 코드를 기반으로 해당 음료의 정보를 수정할 수 있습니다.
   •	음료 이름, 가격, 제조사, 유통기한 등 다양한 속성을 수정할 수 있습니다.

4. 음료 전체 조회

   •	등록된 모든 음료의 목록을 조회할 수 있습니다.
   •	음료의 코드, 이름, 가격 등 주요 정보를 출력합니다.

5. 판매 관리 기능

   •	특정 음료의 판매 정보를 추가하고 관리합니다.
   •	재고 여부를 업데이트하고 판매 중인 음료 목록을 조회할 수 있습니다.


주요 메소드 설명

	•	insertDrink(): 사용자가 새로운 음료를 추가할 때 사용하는 메소드입니다. 음료 정보를 입력받아 DRINK 테이블에 추가합니다.
	•	deleteDrink(): 사용자가 특정 음료를 삭제할 때 사용하는 메소드입니다. 음료 코드를 기반으로 삭제를 진행합니다.
	•	updateDrink(): 음료의 특정 속성을 업데이트하는 메소드입니다.
	•	selectAllDrinkList(): 데이터베이스에 등록된 모든 음료를 조회하고 출력합니다.
	•	addDrinkToSell(): 특정 음료를 판매 목록에 추가하고 재고 여부를 설정합니다.

코드 구조

	•	DrinkDAO: 데이터베이스 접근 객체로, 데이터베이스의 CRUD 작업을 담당합니다.
	•	DrinkDTO: 음료의 속성을 나타내는 데이터 전송 객체입니다.
	•	Application: 사용자와의 인터페이스 역할을 하며, 사용자의 입력에 따라 DAO 메소드를 호출하여 데이터베이스 작업을 수행합니다.

설치 및 실행

	1.	MySQL에 데이터베이스 생성
	•	drinkdb라는 데이터베이스를 생성하고, SQL 파일로 테이블을 구성합니다.
	•	제공된 SQL 스크립트를 사용하여 테이블 및 기본 데이터를 초기화합니다.
	2.	IntelliJ: IntelliJ에서 프로젝트를 가져온 후, Application 클래스를 실행하여 프로그램을 사용합니다.

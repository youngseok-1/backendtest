package com.ohgiraffers.section01.run;

import com.ohgiraffers.section01.model.dao.DrinkDAO;
import com.ohgiraffers.section01.model.dto.DrinkDTO;
import com.ohgiraffers.section01.model.dto.SellDTO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        while (true) {
            System.out.println("========음료 관리 페이지========");
            System.out.println("1. 음료 추가");
            System.out.println("2. 음료 삭제");
            System.out.println("3. 음료 수정");
            System.out.println("4. 음료 전체 조회");
            System.out.println("5. 음료 판매 등록");
            System.out.println("6. 판매중인 음료 조회");
            System.out.println("7. 판매 음료 삭제");
            System.out.println("8. 프로그램 종료");

            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("새로운 음료를 추가합니다.");
                    insertDrink();
                    break;

                case 2:
                    System.out.println("존재하는 음료를 삭제합니다.");
                    deleteDrink();
                    break;

                case 3:
                    System.out.println("기존에 있던 음료를 수정합니다.");
                    updateDrink();
                    break;

                case 4:
                    selectAllDrinkList();
                    break;

                case 5:
                    System.out.println("음료 판매를 등록합니다.");
                    addDrinkToSell();
                    break;
                case 6:
                    selectSellDrinkList();
                    break;
                case 7:
                    System.out.println("판매중인 음료를 삭제합니다.");
                    deleteSell();
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;


            }


        }
    }


    public static void selectAllDrinkList() {

        Connection con = getConnection();

        DrinkDAO dao = new DrinkDAO();
        // 리스트 생성
        List<Map<String, String>> drinkList = dao.selectAllDrinkList(con);

        // 리스트 출력
        for (Map<String, String> drink : drinkList) {
            for (Map.Entry<String, String> entry : drink.entrySet()) {
                System.out.println("음료코드: " + entry.getKey() + ", 음료 이름: " + entry.getValue());
            }
        }
    }

    public static void insertDrink() {
        Connection con = getConnection();
        DrinkDAO dao = new DrinkDAO();

        // 사용자에게 값 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.print("새로운 음료 코드를 입력하세요 : (D로 시작하세요) ");
        String code = sc.nextLine();
        System.out.print("새로운 음료 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("가격을 입력하세요: ");
        int price = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        System.out.print("제로 여부(Y/N): ");
        boolean isZero = sc.nextLine().equalsIgnoreCase("Y"); //"Y"를 안쓰면 "N"으로 입력받게 해줌
        System.out.print("제조사 코드(C1 = 코카콜라, C2 = 칠성, C3 = 동아오츠카, C4 = 해태음료, C5 = etc): ");
        String company = sc.nextLine();
        System.out.print("분류 코드(T1 = 탄산, T2 = 에너지드링크, T3 = 쥬스, T4 = 이온, T5 = 그 외): ");
        String type = sc.nextLine();
        System.out.print("유통기한: ");
        LocalDate expiryDate = LocalDate.parse(sc.nextLine());
        System.out.print("용량(250ml, 355ml, 500ml): ");
        String size = sc.nextLine();

        // 새로운 음료 DTO 생성
        DrinkDTO newDrink = new DrinkDTO(code, name, price, isZero, company, type, expiryDate, size);

        // DAO를 통해 음료 추가하기
        int result = dao.insertDrink(con, newDrink);

        if (result > 0) {
            System.out.println("음료 추가 성공!");
        } else {
            System.out.println("음료 추가 실패!");
        }

        close(con);
    }

    public static void deleteDrink() {
        Connection con = getConnection();
        DrinkDAO dao = new DrinkDAO();

        // 사용자로부터 삭제할 음료 코드 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 음료의 코드를 입력하세요 : ");
        String drinkCode = sc.nextLine();

        // DAO를 통해 음료 삭제하기
        int result = dao.deleteDrink(con, drinkCode);

        if (result > 0) {
            System.out.println("음료 삭제 성공!");
        } else {
            System.out.println("음료 삭제 실패! 해당 코드가 존재하지 않을 수 있습니다.");
        }


        close(con);
    }

    public static void updateDrink() {
        Connection con = getConnection();
        DrinkDAO dao = new DrinkDAO();

        // 사용자로부터 수정할 음료 코드 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 음료의 코드를 입력하세요 : ");
        String updateCode = sc.nextLine();

        // 수정할 정보 입력하기
        System.out.print("새로운 음료 이름을 입력하세요: ");
        String newName = sc.nextLine();
        System.out.print("새로운 가격을 입력하세요: ");
        int newPrice = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        System.out.print("제로 여부(Y/N): ");
        boolean newZero = sc.nextLine().equalsIgnoreCase("Y"); //"Y"를 안쓰면 "N"으로 입력받게 해줌
        System.out.print("제조사 코드(C1 = 코카콜라, C2 = 칠성, C3 = 동아오츠카, C4 = 해태음료, C5 = etc): ");
        String newCompany = sc.nextLine();
        System.out.print("분류 코드(T1 = 탄산, T2 = 에너지드링크, T3 = 쥬스, T4 = 이온, T5 = 그 외): ");
        String newType = sc.nextLine();
        System.out.print("유통기한: ");
        LocalDate newExpiryDate = LocalDate.parse(sc.nextLine());
        System.out.print("용량(250ml, 355ml, 500ml): ");
        String newSize = sc.nextLine();

        // 수정된 음료 DTO 생성
        DrinkDTO updateDrink = new DrinkDTO(updateCode, newName, newPrice, newZero, newCompany, newType, newExpiryDate, newSize);

        // DAO를 통해 음료 수정
        int result = dao.updateDrink(con, updateDrink);

        if (result > 0) {
            System.out.print("음료 수정 성공!");
        } else {
            System.out.print("음료 수정 실패!");
        }

        close(con);


    }
    public static void addDrinkToSell() {
        Connection con = getConnection();
        DrinkDAO dao = new DrinkDAO();

        Scanner sc = new Scanner(System.in);

        // 사용자로부터 음료 코드 입력받기
        System.out.print("판매할 음료의 코드를 입력하세요: ");
        String drinkCode = sc.nextLine();

        //  입력받은 음료 코드가 DRINK 테이블에 있는지 확인
        String existingDrinkCode = dao.selectDrinkCode(con, drinkCode);

        if (existingDrinkCode == null) {
            System.out.println("해당 음료 코드는 존재하지 않습니다.");
            return;
        }

        //  재고 여부 입력받기
        System.out.print("재고가 있는지 여부를 입력하세요 (Y/N): ");
        boolean isAvailable = sc.nextLine().equalsIgnoreCase("Y");

        //  SELL 테이블에 음료 추가
        int result = dao.insertSellRecord(con, drinkCode, isAvailable);

        if (result > 0) {
            System.out.println("음료 판매 정보가 성공적으로 추가되었습니다.");
        } else {
            System.out.println("음료 판매 정보 추가에 실패했습니다.");
        }

        close(con);
    }

    public static void selectSellDrinkList() {

        Connection con = getConnection();

        DrinkDAO dao = new DrinkDAO();
        List<SellDTO> sellList = dao.selectSellDrinkList(con);

        for (SellDTO sell : sellList) {
            System.out.println("판매코드: " + sell.getSellCode() +
                              ", 재고여부:" + sell.getIsAvailable() +
                              ", 음료코드:" + sell.getDrinkCode());
            }
        close(con);
        }

    public static void deleteSell() {
        Connection con = getConnection();
        DrinkDAO dao = new DrinkDAO();

        // 사용자로부터 삭제할 음료 코드 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 판매코드를 입력해주세요 : ");
        String deleteSellDrink = sc.nextLine();

        // DAO를 통해 판매 삭제
        int result = dao.deleteSell(con, deleteSellDrink);

        if (result > 0) {
            System.out.println("판매 정보 삭제 성공!");
        } else {
            System.out.println("판매 정보 삭제 실패! 판매 코드를 확인해주세요!");
        }
        close(con);
    }
    }



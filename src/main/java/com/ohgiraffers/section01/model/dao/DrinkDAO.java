package com.ohgiraffers.section01.model.dao;

import com.ohgiraffers.section01.model.dto.DrinkDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class DrinkDAO {

    private Properties prop = new Properties();

    public DrinkDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, String>> selectAllDrinkList(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<Map<String, String>> selectAllDrinkList = null;

        String query = prop.getProperty("selectAllDrinkList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            selectAllDrinkList = new ArrayList<>();

            while (rset.next()) {
                Map<String, String> category = new HashMap<>();
                category.put(rset.getString("DRK_CODE"), rset.getString("DRK_NAME"));

                selectAllDrinkList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(rset);
        }
        return selectAllDrinkList;
    }

    public int insertDrink(Connection con, DrinkDTO newDrink) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertDrink");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newDrink.getCode());
            pstmt.setString(2, newDrink.getName());
            pstmt.setInt(3, newDrink.getPrice());
            pstmt.setBoolean(4, newDrink.getZero());
            pstmt.setString(5, newDrink.getCompany());
            pstmt.setString(6, newDrink.getType());
            pstmt.setDate(7, java.sql.Date.valueOf(newDrink.getExpiryDate()));
            pstmt.setString(8, newDrink.getSize());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteDrink(Connection con, String drinkCode) {

        PreparedStatement pstmt = null;
        int result = 0;

        // 이미 prop을 썻으므로 초기화를 안시켜도됨.
        String query = prop.getProperty("deleteDrink");

        try {
            //PrepareStatement(바뀔 준비 단계) 생성 및 쿼리 준비.
            pstmt = con.prepareStatement(query);

            // 음료 코드 설정
            pstmt.setString(1, drinkCode);

            // 삭제 실행
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int updateDrink(Connection con, DrinkDTO updateDrink) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("updateDrink");

        try {
            pstmt = con.prepareStatement(query);

            // DrinkDTO 객체에서 데이터를 가져와 pstmt에 설정
            pstmt.setString(1, updateDrink.getName());
            pstmt.setInt(2, updateDrink.getPrice());
            pstmt.setBoolean(3, updateDrink.getZero());
            pstmt.setString(4, updateDrink.getCompany());
            pstmt.setString(5, updateDrink.getType());
            pstmt.setDate(6, java.sql.Date.valueOf(updateDrink.getExpiryDate()));
            pstmt.setString(7, updateDrink.getSize());
            pstmt.setString(8, updateDrink.getCode());

            // 변경된 값 저장
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }


    }




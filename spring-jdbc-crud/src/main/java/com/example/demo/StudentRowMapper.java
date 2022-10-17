package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    // 使用頻率高（建議背起來）
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        // 先建立物件實例，定義好成員變數與 get／set 方法。
        Student student = new Student();
        student.setId(rs.getInt("id")); // 取得該 column 的 id
        student.setName(rs.getString("name"));

        return student;
    }
}

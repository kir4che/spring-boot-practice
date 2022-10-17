package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class
StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // update：新增 INSERT INTO
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("MySQL 自動產生的 id 為：" + id);

        return "執行 INSERT SQL";
    }

    // batchUpdate：批量新增 INSERT INTO
    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> list) {
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        // 固定寫法
        MapSqlParameterSource[] params = new MapSqlParameterSource[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);

            params[i] = new MapSqlParameterSource();
            params[i].addValue("studentName", student.getName()); // 用途與 map.put() 一樣
        }

        namedParameterJdbcTemplate.batchUpdate(sql, params);

        return "執行一批 INSERT SQL";
    }

    // update：刪除 DELETE FROM
    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable Integer id) {
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", id);

        namedParameterJdbcTemplate.update(sql, map);

        return "執行 DELETE SQL";
    }

//    // query：查詢 SELECT
//    @GetMapping("/students")
//    // 回傳型別改成 List<Student> 表示要回傳所有 student 資料
//    public List<Student> select() {
//        String sql = "SELECT id, name FROM student";
//
//        Map<String, Object> map = new HashMap<>();
//
//        // 透過 StudentRowMapper 將 SELECT 所查詢出來的數據轉換成 Student 型別，再存放到 list。
//        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
//
//        return list;
//    }

    // query：針對 id 查詢 SELECT
    @GetMapping("/students/{id}")
    public Student selectById(@PathVariable Integer id) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", id);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        // 先判斷該 list 裡面有沒有數據再去用 list.get()
        if (list.size() > 0) return list.get(0);
        else return null;
    }
}

package com.example.producer.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import com.example.producer.models.Record;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DataService {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public DataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {

        String createTableSql = "CREATE TABLE IF NOT EXISTS records (id INT PRIMARY KEY, data VARCHAR(255))";
        jdbcTemplate.execute(createTableSql);


        String insertSampleData = "INSERT INTO records (id, data) VALUES (1, 'Sample Data 1'), (2, 'Sample Data 2'), (3,'Sample Data 3')";
        jdbcTemplate.execute(insertSampleData);
    }




    public List<Record> fetchData() {
        String sql = "SELECT * FROM records";
        return jdbcTemplate.query(sql, new RowMapper<Record>() {
            @Override
            public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Record(rs.getInt("id"), rs.getString("data"));
            }
        });
    }
}

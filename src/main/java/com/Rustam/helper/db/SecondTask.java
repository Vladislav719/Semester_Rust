package com.Rustam.helper.db;

import com.Rustam.model.FirstQuery;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 28.12.2014.
 */
public class SecondTask {
    protected Connection connection = null;

    public SecondTask() {
        //создаем соединение
        connection = DBConnection.getConnection();
    }

    public ModelMap firstRequestHandler(ModelMap model) {
        List<FirstQuery> firstQueryList = new ArrayList<FirstQuery>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from ROUTE JOIN DATEP on routeid = routeid_town");
            while (rs.next()) {
                FirstQuery firstQuery = new FirstQuery();
                firstQuery.setCost(rs.getInt("cost")+"");
                firstQuery.setCountry(rs.getString("country"));
                firstQuery.setHotel(rs.getString("hotel"));
                firstQuery.setPeriod(rs.getInt("period"));
                firstQuery.setRouteid(rs.getInt("routeid"));
                firstQuery.setRouteName(rs.getString("routename"));
                firstQuery.setType(rs.getInt("type"));
                firstQuery.setWorker(rs.getString("worker"));
                firstQueryList.add(firstQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("listFirst", firstQueryList);
        return model;
    }

    public ModelMap secondRequestHandler(ModelMap model) {
        List<FirstQuery> list = new ArrayList<FirstQuery>();
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery("SELECT town,country, hotel, sum(period) as period, min(type) as type FROM datep join route on routeid_town = routeid GROUP BY routeid, town");
            while (rs.next()) {
                FirstQuery firstQuery = new FirstQuery();
                firstQuery.setTown(rs.getString("town"));
                firstQuery.setCountry(rs.getString("country"));
                firstQuery.setHotel(rs.getString("hotel"));
                firstQuery.setType(rs.getInt("type"));
                firstQuery.setPeriod(rs.getInt("period"));
                list.add(firstQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("listSecond", list);
        return model;
    }


}

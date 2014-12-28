package com.Rustam.helper.db;

import com.Rustam.model.ThirdQuery;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.ui.ModelMap;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Владислав on 28.12.2014.
 */
public class ThirdTask {

    protected Connection connection = DBConnection.getConnection();

    public ModelMap doQueryThird(ModelMap model, int count) {
        return model;
    }

    public ModelMap doQueryThird(ModelMap  model, String date) {
        List<ThirdQuery > list =new ArrayList<ThirdQuery>();
        List<String > listDate = new ArrayList<String>();
        if (date == null) {
            try {
                ResultSet rs = connection.createStatement().executeQuery("SELECT DATESTART from DATEP GROUP BY DATESTART");
                while (rs.next()) {
                    listDate.add(rs.getDate("datestart").toString());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            model.addAttribute("task3date", listDate);
            return model;
        }

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * from datep INNER JOIN route on routeid = routeid_town GROUP BY town HAVING startdate >?");
            Date sqlDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
            statement.setDate(1, sqlDate);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ThirdQuery query = new ThirdQuery();
                query.setWorker(rs.getString("worker"));
                query.setHotel(rs.getString("hotel"));
                query.setTown(rs.getString("town"));
                query.setDallar(rs.getString("returnp"));
                query.setDateStart(rs.getDate("dateStart").toString()+"");
                list.add(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model
                .addAttribute("task31", list);


        return model;
    }

    public ModelMap avgHotelGet(ModelMap model) {
        //вот тут не стоит спрашивать почему класс создается здесь |-:
        //p.s. просто нужна была структура для хранения /-:

        List<HotelType> typeHotelList = new ArrayList<HotelType>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT avg(type) as type, hotel from datep GROUP BY hotel ORDER BY avg(type) DESC");
            while (rs.next()) {
                HotelType a = new HotelType();
                a.setHotel(rs.getString("hotel"));
                a.setType(rs.getInt("type"));
                typeHotelList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("typeHotel", typeHotelList);
        return model;

    }
}

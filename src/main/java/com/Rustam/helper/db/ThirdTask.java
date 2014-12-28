package com.Rustam.helper.db;

import org.springframework.ui.ModelMap;

import java.sql.Connection;

/**
 * Created by Владислав on 28.12.2014.
 */
public class ThirdTask {

    protected Connection connection = DBConnection.getConnection();

    public ModelMap doQuery(ModelMap  model) {

        

        return model;
    }
}

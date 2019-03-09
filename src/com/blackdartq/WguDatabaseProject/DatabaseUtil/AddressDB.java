package com.blackdartq.WguDatabaseProject.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//class AddressHolder{
//    ArrayList<String> countries = new ArrayList<>();
//}


public class AddressDB extends DatabaseUtil {
//    ArrayList<AddressHolder> addressHolders = new ArrayList<>();
    private ArrayList<String> countries = new ArrayList<>();

    /**
     *
     */
    public ArrayList<String> getCountries() {
        countries.clear();
        getCountriesFromDatabase();
        return countries;
    }

    /**
     *
     */
    public void getCountriesFromDatabase(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT country FROM country;");
            countries.clear();
            while(resultSet.next()){
                countries.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCity(String city, int countryId){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO city VALUE(null, ?, ?, CURDATE(), 'test', CURRENT_TIMESTAMP, 'test');");
            ps.setString(1, city);
            ps.setInt(2, countryId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't add city to the database");
        }
    }
}


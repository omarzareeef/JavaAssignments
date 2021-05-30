/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omarz
 */
public class CityDAO {

    List<City> cities = new ArrayList<>();

    public CityDAO() {
        super();
    }

    public List<City> readCitiesCSV(String fileName) {
        List<String> rows = new ArrayList<>();
        List<City> cities = new ArrayList<>();

        File cityInfo = new File(fileName);
        try {
            rows = Files.readAllLines(cityInfo.toPath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("An Issue has been happend during reading Cities info: " + e);
        }
        cities = creatCity(rows, cities);
        return cities;
    }

    public List<City> creatCity(List<String> rows, List<City> Cities) {

        for (int i = 1; i < rows.size(); i++) {
            String line = rows.get(i);
            String[] fields = line.split(",");

            for (int j = 0; j < fields.length; j++) {
                fields[j] = fields[j].trim();
            }

            City city = new City(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
            cities.add(city);
        }

        return cities;
    }
}

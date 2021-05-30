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
public class CountryDAO {

    List<Country> countries = new ArrayList<>();

    public CountryDAO() {
        super();
    }

    public List<Country> readCountriesCSV(String fileName) {
        List<String> rows = new ArrayList<>();
        List<Country> countries = new ArrayList<>();

        File countryInfo = new File(fileName);
        try {
            rows = Files.readAllLines(countryInfo.toPath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("An Issue has been happend during reading Countries info: " + e);
        }
        countries = creatCountry(rows, countries);
        return countries;
    }

    public List<Country> creatCountry(List<String> rows, List<Country> Countries) {

        for (int i = 1; i < rows.size(); i++) {
            String line = rows.get(i);
            String[] fields = line.split(",");

            for (int j = 0; j < fields.length; j++) {
                fields[j] = fields[j].trim();
            }

            Country country = new Country(fields[0], fields[1]);
            countries.add(country);
        }

        return countries;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author omarz
 */
public class Main {

    public static void main(String[] args) {
        List<City> cities0 = new ArrayList<>();
        Map<String, List<City>> cityMap = new HashMap<>();
        double median, lQuar, uQuar;

        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.readCountriesCSV("countries.csv");

        CityDAO cityDAO = new CityDAO();
        List<City> cities = cityDAO.readCitiesCSV("cities.csv");

        for (Country c : countries) {
            List<City> cities1 = new ArrayList<>();
            cities1 = cities.stream().filter(o -> o.getCode().equalsIgnoreCase(c.getCode()))
                    .collect(Collectors.toList());
            cityMap.put(c.getCode(), cities1);
        }
        List<City> cit = sortCitiesOnPopulation(cityMap, "1");
        System.out.println("Sort cities by population on specific country code:");
        System.out.println(cit);

        System.out.println("Highest population city of each country:");
        System.out.println(hPopulationCityPerCountry(cityMap));

        System.out.print("Highest population city by continent: ");

        cities0 = hPopulationCityPerCountry(cityMap);
        System.out.println(cities0.stream().max(Comparator.comparing(City::getPopulation)).get().getContinent());

        cit = sortCitiesOnPopulation(cities);
        if (cit.size() % 2 == 0) {
            median = ((double) cit.get(cit.size() / 2).population + (double) cit.get(cit.size() / 2 - 1).population) / 2;
            lQuar = ((double) cit.get((cit.size() / 2) / 2).population + (double) cit.get((cit.size() / 2) / 2 - 1).population) / 2;
            uQuar = ((double) cit.get((cit.size() / 2) / 2 + ((cit.size() / 2) / 2) + 1).population + (double) cit.get((cit.size() / 2) + (cit.size() / 2) / 2).population) / 2;
        } else {
            median = (double) cit.get(cit.size() / 2).population;
            lQuar = (double) cit.get((cit.size() / 2) / 2).population;
            uQuar = (double) cit.get(cit.size() / 2 + (cit.size() / 2) / 2 + 1).population;
        }
        System.out.println("Median: " + median + "\nLower Quartile: " + lQuar + "\nUpper Quartile: " + uQuar);

        System.out.println("Average: " + cit.stream().mapToDouble(City::getPopulation).average().getAsDouble());

        Exercise21 exercise21;
        exercise21 = (n, m) -> n.length() < m.length() ? n : m;
        System.out.println(exercise21.betterString("Omar", "Khalid"));

        Exercise22 exercise22;
        exercise22 = (s) -> {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        };
        System.out.println(exercise22.containOnlyLetter("oma1r"));
    }

    public static List<City> sortCitiesOnPopulation(Map<String, List<City>> cityMap, String key) {
        List<City> cities = cityMap.get(key).stream()
                .sorted((o1, o2) -> Integer.valueOf(o1.getPopulation()).compareTo(Integer.valueOf(o2.getPopulation())))
                .collect(Collectors.toList());
        return cities;
    }

    public static List<City> sortCitiesOnPopulation(List<City> cities) {
        cities = cities.stream()
                .sorted((o1, o2) -> Integer.valueOf(o1.getPopulation()).compareTo(Integer.valueOf(o2.getPopulation())))
                .collect(Collectors.toList());
        return cities;
    }

    public static List<City> hPopulationCityPerCountry(Map<String, List<City>> cityMap) {
        List<City> cities = new ArrayList<>();
        Iterator<Map.Entry<String, List<City>>> iterCountry = cityMap.entrySet().iterator();
        while (iterCountry.hasNext()) {
            iterCountry.next().getValue().stream().max(Comparator.comparing(City::getPopulation)).ifPresent(cities::add);
        }
        return cities;
    }
}

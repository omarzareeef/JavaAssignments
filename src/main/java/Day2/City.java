/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

/**
 *
 * @author omarz
 */
public class City {

    String code, name, continent;
    int surface_area, population;

    public City(String code, String name, String continent, int surface_area, int population) {
        super();
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surface_area = surface_area;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(int surface_area) {
        this.surface_area = surface_area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City [code=" + code + ", name=" + name + ", continent=" + continent + ", surface_area=" + surface_area
                + ", population=" + population + "]";
    }
}

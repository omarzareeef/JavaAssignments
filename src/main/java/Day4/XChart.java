package Day4;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Category;
import org.knowm.xchart.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class XChart {

    public static void main(String[] args) {

        File file = new File("titanic_csv.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Passenger> passangers = null;
        try {
            passangers = mapper.readValue(file, new TypeReference<List<Passenger>>() {});
        } catch (IOException ex) {
            Logger.getLogger(XChart.class.getName()).log(Level.SEVERE, null, ex);
        }

        passangers.stream().forEach(System.out::println);
        XChart.categoryChartGraph(passangers);
        XChart.pieChartGraph(passangers);

    }

    public static void categoryChartGraph(List<Passenger> allPassanger) {
        List<String> names = allPassanger.stream().map(Passenger::getName).limit(5).collect(Collectors.toList());
        List<Double> ages = allPassanger.stream().map(Passenger::getAge).limit(5).collect(Collectors.toList());

        CategoryChart chart = new CategoryChartBuilder().height(700).width(1020)
                .title("Passenger Ages").xAxisTitle("Names").yAxisTitle("Ages")
                .build();

        chart.addSeries("Passenger Ages Names", names, ages);
        new SwingWrapper<CategoryChart>(chart).displayChart();

    }

    public static void pieChartGraph(List<Passenger> allPassanger) {
        Map<Integer, Long> pclassCount = allPassanger.stream().collect(Collectors.groupingBy(Passenger::getPclass, Collectors.counting()));
        PieChart chart = new PieChartBuilder().height(700).width(1020)
                .title("Passenger Classes").build();
        chart.addSeries("Pclass 1", pclassCount.get(1));
        chart.addSeries("Pclass 2", pclassCount.get(2));
        chart.addSeries("Pclass 3", pclassCount.get(3));
        new SwingWrapper<PieChart>(chart).displayChart();

    }

}

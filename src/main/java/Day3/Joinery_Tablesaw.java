package Day3;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinery.DataFrame;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omarz
 */
public class Joinery_Tablesaw {

    public static void main(String[] args){
        DataFrame<Object> df1 = null,df2 = null;
        Table titanicData1 = null,titanicData2 = null,titanicData3 = null;
        try {
            System.out.println("Joinery Library:");
            df1 = DataFrame.readCsv("titanic.csv");
            df2 = DataFrame.readCsv("titanic.csv");
        } catch (IOException ex) {
            Logger.getLogger(Joinery_Tablesaw.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println("TableSaw Library:");
            titanicData1 = Table.read().csv("titanic.csv");
        } catch (IOException ex) {
            Logger.getLogger(Joinery_Tablesaw.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> omar = new ArrayList<>();
        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        for (int i = 0; i < df1.length(); i++) {
            omar.add(rand.nextInt(upperbound));
        }
        
        df1.add("Omar",omar);
        DataFrame<Object> df3 = df1.joinOn(df2,"Name");
        System.out.println(df3);
        System.out.println(df1.merge(df2));
        
        int rowCount = titanicData1.rowCount ();
        int[] Lst = new int[rowCount];
        for (int i = 0; i < rowCount; i++) {
            Lst[i] = i+1;
        }
        IntColumn numColumn = IntColumn.create("Omar",Lst);
        titanicData1.addColumns(numColumn);
        titanicData2 = titanicData1.select("Pclass","Name","Omar");
        titanicData3 = titanicData1.select("Sex","Age","Omar");
        System.out.println("joining Tablesaw:");
        System.out.println(titanicData2.joinOn("Omar").inner(titanicData3));
    }
}
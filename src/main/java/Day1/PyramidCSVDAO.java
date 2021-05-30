/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omarz
 */
public class PyramidCSVDAO {

    List<Pyramid> pyramids;

    public PyramidCSVDAO() {
        super();
        this.pyramids = new ArrayList<Pyramid>();
    }

    public List<Pyramid> readPyramidsFromCSV(String fileName) {
        File pyramidInfoFile = new File(fileName);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(pyramidInfoFile.toPath());
        } catch (IOException e) {
            System.out.println("An Issue has been happend during reading Pyramids info: " + e);
        }
        for (int lineIdx = 1; lineIdx < lines.size(); lineIdx++) {
            String line = lines.get(lineIdx);
            String[] fields = line.split(",");

            for (int fieldIdx = 0; fieldIdx < fields.length; fieldIdx++) {
                fields[fieldIdx] = fields[fieldIdx].trim();
            }

            Pyramid pyramid = new Pyramid(fields[0], fields[2], fields[4], fields[7]);
            pyramids.add(pyramid);
        }
        return pyramids;
    }
}

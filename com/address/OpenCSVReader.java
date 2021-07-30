package com.address;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    private static final String CSV_PATH ="";

    public static void main(String[] arg){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CSVReader csvReader = new CSVReader(reader);

            List<String[]> records = csvReader.readAll();
            for (String[] record : records){
                System.out.println("Name: "+record[0]);
                System.out.println("Emil: "+record[1]);
                System.out.println("Phone: "+record[2]);
                System.out.println("Country: "+record[3]);
                System.out.println("****************");
            }
//            String[] nextReacord;
//            while ((nextReacord=csvReader.readNext()) !=null){
//                System.out.println("Name: "+nextReacord[0]);
//                System.out.println("Email: "+nextReacord[1]);
//                System.out.println("Phone: "+nextReacord[2]);
//                System.out.println("Country: "+nextReacord[3]);
//                System.out.println("*************************");
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


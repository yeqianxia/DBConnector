package com.qianxia.experiment.excel;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author qianxia
 * @date 2021/12/17  14:02
 */
public class CsvDemo {


    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("/Users/qianxia/IdeaProjects/Experiment/src/main/resources/static/csvDemo.csv")));
        List<String[]> rows = reader.readAll();
        rows.forEach(columns-> Arrays.stream(columns).forEach(System.out::println));


    }
}

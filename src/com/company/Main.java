package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static XSSFWorkbook workbook = new XSSFWorkbook();

    public static void main(String[] args) throws IOException, ParseException {
        // write your code here
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        final List<Date> date = createDatePattern(simpleDateFormat);

        HashMap<Date, List<FileProcess>> startMap = new HashMap<>();
        date.forEach(date1 -> startMap.put(date1, new ArrayList<>()));

        HashMap<Date, List<FileProcess>> finishMap = new HashMap<>();
        date.forEach(date1 -> finishMap.put(date1, new ArrayList<>()));

        Set<FileProcess> fileProcesses = new HashSet<>();
        List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        for (String line : lines) {
            if (line.contains("RowID\t")) {
                continue;
            }
            String[] split = line.split("\t");
            int rowId = Integer.parseInt(split[0]);
            Date start = simpleDateFormat.parse(split[1]);
            Date finish = simpleDateFormat.parse(split[2]);

            startMap.keySet().forEach(dateStart -> {
                if (start.getMonth() == dateStart.getMonth() && start.getYear() == dateStart.getYear()) {
                    startMap.get(dateStart).add(new FileProcess(rowId, start));
                }
            });

            finishMap.keySet().forEach(dateFinish -> {
                if (finish.getMonth() == dateFinish.getMonth() && finish.getYear() == dateFinish.getYear()) {
                    finishMap.get(dateFinish).add(new FileProcess(rowId, finish));
                }
            });
        }

        System.out.println(startMap);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(finishMap);

    }

    private static List<Date> createDatePattern(SimpleDateFormat simpleDateFormat) throws ParseException {
        final List<Date> date = new ArrayList<>();
        date.add(simpleDateFormat.parse("2012-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2012-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2012-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2013-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2013-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2013-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2014-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2014-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2014-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2015-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2015-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2015-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2016-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2016-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2016-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2017-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2017-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2017-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2018-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2018-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2018-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2019-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2019-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2019-12-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2020-01-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-02-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-03-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-04-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-05-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-06-00 00:00:00.000"));

        date.add(simpleDateFormat.parse("2020-07-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-08-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-09-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-10-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-11-00 00:00:00.000"));
        date.add(simpleDateFormat.parse("2020-12-00 00:00:00.000"));
        return date;
    }

    public void getList(List<String> listcriteria) {
        Map<Integer, List<String>> hashmap = new HashMap<Integer, List<String>>();
        //create 5 key value pairs
        for (int i = 0; i < 5; i++) {
            hashmap.put(i, listcriteria);
        }
        System.out.println("hashmap : " + hashmap);
        Set<Integer> keyset = hashmap.keySet();
        int rownum = 0;
        int cellnum = 0;
        XSSFSheet sheet = workbook.getSheetAt(0);
        rownum = 0;
        for (Integer key : keyset) {
            List<String> nameList = hashmap.get(key);
            for (String s : nameList) {
                XSSFRow row = sheet.getRow(rownum++);
                Cell cell = row.getCell(cellnum);
                if (null != cell) {
                    cell.setCellValue(s);
                }
            }
            cellnum++;
            rownum = 0;
        }
    }
}

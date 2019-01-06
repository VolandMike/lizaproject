package com.company;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {


    static XSSFWorkbook workbook = new XSSFWorkbook();

    public void getList(List<Date> listcriteria) {
        Map<Integer, List<Date>> hashmap = new HashMap<>();
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
            List<Date> nameList = hashmap.get(key);
            for (Date s : nameList) {
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

    public static void main(String[] args) throws IOException, ParseException {
        //Creation of List from an Array to test getList Method
        String[] ss = {"a", "b", "c", "d", "e"};
        List<Date> listcriteria = new ArrayList<>(createDatePattern());
        /***********************************************************/

        Test t = new Test();
        // Because I put 5 key values pairs in hashmap (see getList method), I create  Writesheet.xlsx
        // file that contains 5 rows each row contains 5 cell
        FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
        XSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < listcriteria.size(); i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < listcriteria.size(); j++)
                row.createCell(i);
        }
        workbook.write(out);
        out.close();//end creation of Excel file

        // I open Writesheet.xlsx file and write the data on it
        InputStream inp = new FileInputStream(new File("Writesheet.xlsx"));
        workbook = new XSSFWorkbook(inp);
        // listcriteria contains the data that will be written it on  Writesheet.xlsx
        t.getList(listcriteria);
        out = new FileOutputStream(new File("Writesheet.xlsx"));
        workbook.write(out);
        out.close();
        inp.close();
        System.out.println("Writesheet.xlsx written successfully");

    }
    private static List<Date> createDatePattern() throws ParseException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
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


}
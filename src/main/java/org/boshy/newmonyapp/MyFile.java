package org.boshy.newmonyapp;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class MyFile {
    LocalDate d = LocalDate.now();
    protected File MyFile = new File("ايراد يوم " + d.minusDays(1) +".doc");
    private FileWriter fw = new FileWriter(MyFile , true);
    private PrintWriter pw = new PrintWriter(fw , true);
    MyFile() throws IOException {
        MyFile.delete();
        MyFile.createNewFile();
    }

    public void write(String s) throws IOException {
        pw.println(s);
        pw.flush();
    }
    public void close()throws IOException{
        pw.close();
    }
}
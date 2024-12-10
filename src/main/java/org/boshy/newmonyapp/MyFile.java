package org.boshy.newmonyapp;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class MyFile {
    private final LocalDate d = LocalDate.now();
    private final FileOutputStream MyFile;
    private final XWPFDocument document;
    private final XWPFParagraph paragraph;
    private final XWPFRun run;

    public MyFile() throws IOException {
        MyFile = new FileOutputStream("ايراد يوم " + d.minusDays(1) + ".docx");
        document = new XWPFDocument();
        paragraph = document.createParagraph();
        run = paragraph.createRun();

        // تنسيق الفقرة
        paragraph.setAlignment(ParagraphAlignment.RIGHT);

        // تنسيق النصوص
        run.setBold(true);
        run.setLang("AR");
        run.setFontFamily("Arial");
        run.setFontSize(18);
    }

    public void write(String s) {
        run.setText(s);
        run.addBreak(); // إضافة سطر جديد
    }

    public void close() throws IOException {
        // كتابة البيانات إلى الملف
        document.write(MyFile);

        // إغلاق الموارد
        MyFile.close();
        document.close();
    }
}

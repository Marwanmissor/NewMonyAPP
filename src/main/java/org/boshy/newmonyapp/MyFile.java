package org.boshy.newmonyapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class MyFile {
    LocalDate d = LocalDate.now();
    private File MyFile = new File("ايراد يوم " + d.minusDays(1) +".txt");
    private FileWriter fw = new FileWriter(MyFile , true);

    MyFile() throws IOException {
        if(MyFile.exists()){
            System.out.println(MyFile.delete());
            MyFile.createNewFile();
        }else{MyFile.createNewFile();}
          fw.flush();
    }
    public void write(String s) throws IOException {
        fw.write(s);
        fw.flush();
    }
    public void close()throws IOException{
        fw.close();
    }
}

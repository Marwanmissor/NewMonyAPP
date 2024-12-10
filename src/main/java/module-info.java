module org.boshy.newmonyapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires org.apache.poi.ooxml;


    opens org.boshy.newmonyapp to javafx.fxml;
    exports org.boshy.newmonyapp;
}
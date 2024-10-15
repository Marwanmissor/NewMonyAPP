module org.boshy.newmonyapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.boshy.newmonyapp to javafx.fxml;
    exports org.boshy.newmonyapp;
}
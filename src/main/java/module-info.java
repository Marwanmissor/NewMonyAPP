module org.boshy.newmonyapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.boshy.newmonyapp to javafx.fxml;
    exports org.boshy.newmonyapp;
}
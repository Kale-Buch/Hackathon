module com.group.hackathon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group.hackathon to javafx.fxml;
    exports com.group.hackathon;
}
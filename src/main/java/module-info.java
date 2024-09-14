module com.group.hackathon.hackathon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group.hackathon.hackathon to javafx.fxml;
    exports com.group.hackathon.hackathon;
}
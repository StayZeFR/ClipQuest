module fr.clipquest.clipquest {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.clipquest to javafx.fxml;
    exports fr.clipquest;
}
module fr.clipquest.clipquest {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.clipquest.clipquest to javafx.fxml;
    exports fr.clipquest.clipquest;
}
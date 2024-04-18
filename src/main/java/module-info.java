module fr.clipquest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.github.kwhat.jnativehook;
    requires jBCrypt;
    requires java.sql;

    opens fr.clipquest to javafx.fxml;
    opens fr.clipquest.controllers to javafx.fxml;
    opens fr.clipquest.controllers.components to javafx.fxml;
    opens fr.clipquest.models to javafx.base;
    opens fr.clipquest.utils to javafx.base;
    opens fr.clipquest.utils.session to javafx.base;
    exports fr.clipquest;
    exports fr.clipquest.controllers;
    exports fr.clipquest.controllers.components;
    exports fr.clipquest.models;
    exports fr.clipquest.utils;
    exports fr.clipquest.utils.session;
}
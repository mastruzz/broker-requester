module com.agibank.brokerrequester {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires MaterialFX;
    requires mfx.effects;
    requires mfx.core;

    opens com.agibank.brokerrequester to javafx.fxml;
    opens com.agibank.brokerrequester.controller to javafx.fxml;
    exports com.agibank.brokerrequester;
}
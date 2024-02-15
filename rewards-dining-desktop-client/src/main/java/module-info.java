module com.rewardomain.rewardsdiningdesktopclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires jersey.bundle;
    requires com.fasterxml.jackson.datatype.jsr310;




    opens com.rewardomain.rewardsdiningdesktopclient to javafx.fxml;
    exports com.rewardomain.rewardsdiningdesktopclient;
    opens com.rewardomain.rewardsdiningdesktopclient.controller to javafx.fxml;
    exports com.rewardomain.rewardsdiningdesktopclient.entity to com.fasterxml.jackson.databind;
}
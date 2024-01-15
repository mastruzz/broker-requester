package com.agibank.brokerrequester.controller;

import com.agibank.brokerrequester.enums.Environment;
import com.agibank.brokerrequester.enums.PartnerFormatEnum;
import io.github.palexdev.materialfx.controls.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

import java.util.List;

import static com.agibank.brokerrequester.enums.Environment.HOMOLOGACAO;
import static com.agibank.brokerrequester.enums.Environment.LOCALHOST;

public class PrimaryViewController {

    @FXML
    private MFXRadioButton dockToggle;

    @FXML
    private ToggleGroup origin;

    @FXML
    private MFXTextField portField;

    @FXML
    private MFXComboBox<Environment> predefinedHost;

    @FXML
    private MFXTextField requestQuantity;

    @FXML
    private MFXTextField requestTime;

    @FXML
    private MFXButton sendButton;

    @FXML
    private MFXRadioButton toggleTecban;

    @FXML
    private MFXTextField urlField;

    @FXML
    private MFXTextField isoMessageField;

    @FXML
    private MFXButton InfoButton;

    @FXML
    void showInfoText(MouseEvent event) {

    }

    @FXML
    void initialize() {

        setEnviromentComboBox();
        sendButton.setOnAction(event -> sendMessage());

        createInfoTextTooltip();
    }

    private void setEnviromentComboBox() {
        predefinedHost.setItems(Environment.getEnvironmentComboBox());
    }

    @FXML
    private void sendMessage() {
        String host;
        int port;
        if (List.of(LOCALHOST, HOMOLOGACAO).contains(predefinedHost.getSelectedItem())) {
            host = predefinedHost.getSelectedItem().getHost();
            port = predefinedHost.getSelectedItem().getPort();
        } else {
            host = urlField.getText();
            port = Integer.parseInt(portField.getText());
        }

        PartnerFormatEnum partnerFormatMessage = PartnerFormatEnum.verifyPartnerIsTecban(toggleTecban.isSelected());



        String isoMessage = isoMessageField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALERTANDO");
        alert.setContentText(urlField.getText());
        alert.setHeaderText(portField.getText());
        alert.show();
    }

    private void createInfoTextTooltip() {
        Tooltip tooltip = new Tooltip("Regra de envio de mensagem:" +
                "[TECBAN]" +
                "- Todas as mensagens digitadas serão enviadas no mesmo segundo em caso de conexão tecban." +
                "- Caso multiplique as mensagens a quantidade de vezes multiplicadas será enviada no mesmo segundo." +
                "- Se definido tempo, a quantidade de mensagens serão enviadas sequencialmente durante o período definido." +
                "" +
                "[DOCK]" +
                "- Em caso de conexao DOCK será aberta uma nova conexão para cada mensagem." +
                "- Com conexão aberta ela será enviada durante o período definido.");
        Tooltip.install(InfoButton, tooltip);
        InfoButton.setOnMouseEntered(event -> tooltip.show(InfoButton.getScene().getWindow(),
                event.getScreenX() + 10, event.getScreenY() + 10));
        InfoButton.setOnMouseExited(event -> tooltip.hide());
    }
}

package com.agibank.brokerrequester.enums;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public enum Environment {

    LOCALHOST("localhost", 5000),
    HOMOLOGACAO("broker-20.agibank-hom.in", 40005),
    NENHUM("", 0);

    private final String host;
    private final int port;

    Environment(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public static ObservableList<Environment> getEnvironmentComboBox() {

        return FXCollections.observableArrayList(List.of(LOCALHOST, HOMOLOGACAO, NENHUM));
    }
}

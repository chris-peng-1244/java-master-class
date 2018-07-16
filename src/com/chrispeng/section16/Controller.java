package com.chrispeng.section16;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;

public class Controller {
    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;


    public void initialize() {
        task = new Task<>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);

                final ObservableList<String> employees = FXCollections.observableArrayList(
                    "Tim",
                    "Bill",
                    "Jack",
                    "Joan",
                    "Mary",
                    "Bob"
                );
                return employees;
            }
        };

        listView.itemsProperty().bind(task.valueProperty());
    }

    @FXML
    public void buttonPressed() {
        new Thread(task).start();
    }
}

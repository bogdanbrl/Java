package com.bogdanbrl.todolist;

import com.bogdanbrl.todolist.datamodel.TodoData;
import com.bogdanbrl.todolist.datamodel.TodoItem;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.awt.*;
import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public void processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoData.getInstance().addTodoItem(new TodoItem(shortDescription, details, deadlineValue));
    }

}

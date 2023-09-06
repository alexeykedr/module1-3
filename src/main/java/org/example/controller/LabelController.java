package org.example.controller;

import org.example.model.Label;

public class LabelControllerImpl implements LabelController{
    @Override
    public Label createLabel(int id, String nameLabel) {
        return new Label(id, nameLabel);
    }

    @Override
    public void getLabel(Label label) {

    }

    @Override
    public void updateLabel(Label label) {

    }

    @Override
    public void deleteLabel(Label label) {

    }
}

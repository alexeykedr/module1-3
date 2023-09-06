package org.example.controller;

import org.example.model.Label;

import java.awt.*;

public interface LabelController {
    Label createLabel(int id, String label);
    void getLabel(Label label);
    void updateLabel(Label label);
    void deleteLabel(Label label);
}

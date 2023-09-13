package org.example.controller;

import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.repository.gsonImpl.GsonLabelRepositoryImpl;

import java.util.List;

public class LabelController {

    private final LabelRepository labelRepository = new GsonLabelRepositoryImpl();

    public Label createLabel(String nameLabel) {
        Label label = new Label(0, nameLabel);
        return labelRepository.create(label);
    }

    public Label updateLabelById(Integer id, String name) {
        Label label = new Label(id, name);
        label.setName(name);
        return labelRepository.updateById(label);
    }


    public Label getLabelById(Integer id){
        return labelRepository.getById(id);
    }

    public List<Label> getAll() {
        return labelRepository.getAll();
    }
    public void deleteLabelById(Integer id){
         labelRepository.getById(id);
    }

}

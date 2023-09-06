package org.example.controller;

import org.example.model.Writer;

public interface WriterController {
    Writer createWriter(Writer writer);
    void getWriter(Writer writer);
    void updateWriter(Writer writer);
    void deleteWriter(Writer writer);
}

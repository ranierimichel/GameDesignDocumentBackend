package com.rani.GameDesign.projectSketch;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("File")
public class FileSketch extends ProjectSketch{
    private String type;

    public FileSketch() {
    }

    public FileSketch(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

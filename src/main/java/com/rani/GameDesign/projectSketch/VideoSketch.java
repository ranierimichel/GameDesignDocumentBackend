package com.rani.GameDesign.projectSketch;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Video")
public class VideoSketch extends ProjectSketch{
    private int length;

    public VideoSketch() {
    }

    public VideoSketch(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

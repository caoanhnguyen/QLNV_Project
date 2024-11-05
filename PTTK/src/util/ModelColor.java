
package util;

import java.awt.Color;

public class ModelColor {
    Color color;
    float position;

    public Color getColor() {
        return color;
    }

    public float getPosition() {
        return position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public ModelColor() {
    }

    public ModelColor(Color color, float position) {
        this.color = color;
        this.position = position;
    }
    
    
}

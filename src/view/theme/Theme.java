package view.theme;

import controller.widget.GridWidget;
import model.block.Block;
import model.grid.Grid;

import java.awt.*;

public abstract class Theme {

    protected String name;

    public Theme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid);
}

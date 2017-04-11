package com.sslab.pokemon.guicomponent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jerry on 2017/3/27.
 */
public class BGPanel extends JPanel {
    Image bgImage;
    public BGPanel(Image bgImage)
    {
        super();
        this.bgImage = bgImage;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}

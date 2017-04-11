package com.sslab.pokemon;

/**
 * Created by jerry on 2017/3/19.
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PokemonSprite {

    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 40;
    private static final int TILE_HEIGHT = 30;

    public static BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("res/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }


    public static BufferedImage getSprite(int id) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite("pokemonAll");
        }

        int xGrid = id%16;
        int yGrid = id/16;

        return getScaledImage(spriteSheet.getSubimage(xGrid * TILE_SIZE , yGrid * TILE_HEIGHT, TILE_SIZE, TILE_HEIGHT),80,60);
    }
    private static ImageIcon _bushIcon;
    public static ImageIcon bushIcon()
    {
        if(_bushIcon == null)
            _bushIcon = new ImageIcon(getScaledImage(loadSprite("bush"),80,60));
        return _bushIcon;
    }
    private static ImageIcon _pokemonIcon;
    public static ImageIcon pokeballIcon()
    {
        if(_pokemonIcon == null)
            _pokemonIcon = new ImageIcon(getScaledImage(loadSprite("pokeball"),80,60));
        return _pokemonIcon;
    }

    public static BufferedImage getScaledImage(BufferedImage srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

}
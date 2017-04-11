package com.sslab.pokemon.guicomponent;

import com.sslab.pokemon.PokemonSprite;

import javax.swing.*;
import java.util.Random;

/**
 * Created by jerry on 2017/3/26.
 */
public class PokemonLabel extends JLabel{
    Random a;
    public PokemonLabel()
    {
        setIcon(PokemonSprite.bushIcon());
        a =new Random();
        id=monsterID[a.nextInt(5)];
        counter= 0;
        //System.out.println("label");
        // BufferedImage b = PokemonSprite.getSprite(id);
         //ImageIcon icon = new ImageIcon(b);
       // this.setIcon(icon);
    }
    public int id;
    public int[] monsterID = {0,1,2,62,64};
    int counter = 0;
    public void Update() {
        /// /TODO setup a counter, if time up you may want to change to another state
        if (a.nextInt(2) == 1)
            counter++;

        //System.out.println(counter);
        if (counter >= 4)
        {
           // System.out.println("do something");
            counter -= counter;
            if (state == WhacPokemonState.Hide) {
                state = WhacPokemonState.Show;
                this.popPokemon();
            } else {
                if(a.nextInt(2)==0)
                    id = monsterID[a.nextInt(5)];

                state = WhacPokemonState.Hide;
                this.hidePokemon();
            }
        }

    }

    public void popPokemon(){
        //TODO when a pokemon pop u
        //System.out.println("pop");
        setIcon(new ImageIcon(PokemonSprite.getSprite(id)));
    }
    public void hidePokemon()
    {
        //TODO when the pokemon hide into the bushes
        setIcon(PokemonSprite.bushIcon());
    }
    public int caught()
    {
        //TODO when player caught the pokemon

        this.setIcon(PokemonSprite.pokeballIcon());
        state = WhacPokemonState.Hide;
        int ans = id;
        counter=4;
        int nextID = a.nextInt(5);
        id = monsterID[nextID];
        return ans;
    }

    public boolean isCatchable()
    {
        //a beautiful way to write it, no need to use if
        return state == WhacPokemonState.Show;
    }
    WhacPokemonState state = WhacPokemonState.Hide;

}
enum WhacPokemonState{
    Hide,Show,Caught
}

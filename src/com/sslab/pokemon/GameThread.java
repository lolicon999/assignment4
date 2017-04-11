package com.sslab.pokemon;

import com.sslab.pokemon.guicomponent.PokemonLabel;

import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/26.
 */
public class GameThread implements Runnable {
    ArrayList<PokemonLabel> pokemons;
    Thread mainThread;
        public GameThread(ArrayList<PokemonLabel> pokemonLabels){
            //TODO create and start the thread
            this.pokemons = pokemonLabels;
            mainThread = new Thread(this);
            mainThread.start();
        }



        @Override
        public void run() {
            while(true)
            {
               //System.out.println("is running");
                //TODO Update the pokemonLabels
                for(int c1=0;c1<5;c1++)
                {
                    pokemons.get(c1).Update();
                }
                //TODO use Thread.sleep to make the loop go slower
                try {
                    mainThread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}

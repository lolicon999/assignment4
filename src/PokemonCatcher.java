import com.sslab.pokemon.GameThread;
import com.sslab.pokemon.guicomponent.BGPanel;
import com.sslab.pokemon.guicomponent.PokemonLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/26.
 */
public class PokemonCatcher {
    GameThread gameThread;
    private JPanel root;
    private JPanel bgPanel;
    private JLabel pokemon1;
    private JLabel pokemon2;
    private JLabel pokemon3;
    private JLabel pokemon4;
    private JLabel pokemon5;
    private JLabel scoreLabel;

    ArrayList<PokemonLabel> pokemons;
    int score=0;
    public PokemonCatcher() {

        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //force cast and get pokemon from the event component
                PokemonLabel pokemon = (PokemonLabel) e.getComponent();
                System.out.println("clicked");
                //TODO see if pokemon is catchable, update the UI with SwingUtilities.invokeLater
                if(pokemon.isCatchable())
                {

                    int now = pokemon.caught();
                    if(now==0||now==1||now==2)
                        score++;
                    else
                        score--;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run()
                        {
                            scoreLabel.setText(Integer.toString(score));
                        }
                    });

                }

            }
        };

        //add mouse listeners to all the pokemonLabels
        for(JLabel pokemon:pokemons)
        {
            pokemon.addMouseListener(listener);
        }

        //create the game thread,
        gameThread = new GameThread(pokemons);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("PokemonCatcher");
        frame.setContentPane(new PokemonCatcher().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);
    }


    private void createUIComponents() {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("res/bg.png"));
        } catch (IOException e) {
        }
        bgPanel = new BGPanel(img);
        pokemons = new ArrayList<>();

        for(int i=0;i<5;i++)
            pokemons.add(new PokemonLabel());

        pokemon1 = pokemons.get(0);
        pokemon2 = pokemons.get(1);
        pokemon3 = pokemons.get(2);
        pokemon4 = pokemons.get(3);
        pokemon5 = pokemons.get(4);

    }
}

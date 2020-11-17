package Game.World;

import Game.Entities.Dynamic.Client;
import Game.Entities.Dynamic.Player;
import Game.Entities.Static.BaseCounter;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class BaseWorld {

    public BufferedImage Background;

    public BaseCounter[] Counters;

    public Handler handler;

    public ArrayList<Client> clients = new ArrayList<>();

    public BaseWorld(BufferedImage Background, BaseCounter[] Counters, Handler handler, Player player){
        this.Background = Background;
        this.Counters = Counters;
        this.handler=handler;
        handler.setWorld(this);
        handler.setPlayer(player);
    }

    int position = 0;
    public Client generateClient(){
    	position++;

        Client client =  new Client(0,96,handler, position, 0);
        this.clients.add(client);
        if (position >=5){
            int counter = 1;
            for(Client cl: handler.getWorld().clients){
                cl.position = counter;
                counter++;
            }
        }
        return client;
    }

    public void tick(){

    }

    public void render(Graphics g){

    }
}

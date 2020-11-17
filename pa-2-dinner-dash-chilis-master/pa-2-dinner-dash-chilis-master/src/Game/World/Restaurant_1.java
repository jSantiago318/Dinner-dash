package Game.World;

import Game.Entities.Dynamic.Client;
import Game.Entities.Dynamic.Player;
import Game.Entities.Static.*;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.util.ArrayList;

public class Restaurant_1 extends BaseWorld {
    private int count=0;
    private int capacity = 5;
    public Restaurant_1(BaseCounter[] Counters, Handler handler) {
        super(Images.floor,Counters, handler, new Player(null,0,650,handler));

    }

    public void tick(){
        count++;
        if(count >= 5*60 && !isFull()){
            count = 0;
            for(Client client: this.clients){
                    client.move();
                }
            this.generateClient();
        }else if(count >= 5*60 && isFull()){
            count=0;
            boolean left=false;
            Client toLeave = null;
            ArrayList<Client> toMove = new ArrayList<>();
            for (Client client : this.clients) {
                if (client.isInspector && client.isLeaving){
                    handler.getPlayer().money = handler.getPlayer().money/2;
                    Client.inspectleft++;
                }
                if (client.isLeaving && !left) {
                    toLeave = client;
                    left=true;
                }else if (left) {
                    toMove.add(client);
                }
            }
            if(left){
                this.clients.remove(toLeave);
                for (Client client : toMove) {
                    client.move();
                }
                this.generateClient();
            }  
        }

        for(Client client: this.clients){
            client.tick();
        }
        for(BaseCounter counter: Counters){
            counter.tick();
        }
        handler.getPlayer().tick();
    }

    public boolean isFull(){
        return this.clients.size() >=capacity;
    }
    public void render(Graphics g){
        g.drawImage(Background,0,0,handler.getWidth(), handler.getHeight(),null);
        g.drawImage(Images.welcome,5,90,50,90,null);
        g.drawImage(Images.dishCart, 750,450, 90, 100, null);
        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3,162,96,96,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3+96,192,52,52,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3-52,192,52,52,null);

        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3,258,96,96,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3+96,288,52,52,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3-52,288,52,52,null);
        
        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3,450,96,96,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3+96,480,52,52,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3-52,480,52,52,null);
        
        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3,354,96,96,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3+96,384,52,52,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3-52,384,52,52,null);

        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3+handler.getWidth()/3,162,96,96,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3+handler.getWidth()/3+96,192,52,52,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3+handler.getWidth()/3-52,192,52,52,null);

        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3+handler.getWidth()/3,258,96,96,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3+handler.getWidth()/3+96,288,52,52,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3+handler.getWidth()/3-52,288,52,52,null);
        
        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3+handler.getWidth()/3,450,96,96,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3+handler.getWidth()/3+96,480,52,52,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3+handler.getWidth()/3-52,480,52,52,null);
        
        g.drawImage(Images.kitchenChairTable[0],handler.getWidth()/3+handler.getWidth()/3,354,96,96,null);
        g.drawImage(Images.kitchenChairTable[2],handler.getWidth()/3+handler.getWidth()/3+96,384,52,52,null);
        g.drawImage(Images.kitchenChairTable[1],handler.getWidth()/3+handler.getWidth()/3-52,384,52,52,null);

        for(Client client: clients){
            client.render(g);
        }

        for(BaseCounter counter: Counters){
            counter.render(g);
        }
        handler.getPlayer().render(g);
    }
}

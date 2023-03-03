import java.awt.*;
import java.lang.Thread;
import java.nio.Buffer;
import java.lang.Runnable;
import java.awt.image.*;


public class Game extends Canvas implements Runnable{
    private Frame frame;
    private Board board;
    private boolean gameRunning;
    private Thread gamThread;
    public Game(){
        gameRunning = false;
        frame=new Frame(this);
        board=new Board();
        addMouseListener(board);
    }
    public synchronized void start(){
        if(gameRunning)
        return;

        gameRunning=true;
        gamThread=new Thread(this);
        gamThread.start();
    }

    public synchronized void stop(){
        if(!gameRunning)
        return;
        
        gameRunning=false;
        try{
            gamThread.join();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void run(){
        long lastTime=System.currentTimeMillis();
        double amountOfUpdates=60.0;
        double ns=1000000000/amountOfUpdates;
        double catchUp=0;
        int updates=0;
        int FPS=0;
        long timerCheck=System.currentTimeMillis();

        while(gameRunning){
            long now=System.nanoTime();
            catchUp+=(now-lastTime)/ns;
            lastTime=now;

            while(catchUp>=1){
                update();
                updates++;
                catchUp--;

            }

            draw();
            FPS++;
            if(System.currentTimeMillis()-timerCheck>1000){
                timerCheck+=1000;
                System.out.println("Updates: "+updates+", FPS: "+FPS);
                FPS=0;
                updates=0;
            }

        }
        stop();
    }

    public void update(){

    }
    public void draw(){
        BufferStrategy bs=this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();
        g.setColor(new Color(150,123,182));
        g.fillRect(0, 0, Frame.WIDTH, Frame.HEIGHT);
        if(board !=null){
            board.draw(g);
        }

        bs.show();
        g.dispose();


    }

    public static void main(String[] args) {
        Game game=new Game();

    }
}

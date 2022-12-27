public class GameController {
    private static Player[] players = new Player[2];
    private GameBoard board;
    private static GameController uniqueInstance;

    public static void updateNumCells(short blues, short reds){
        players[0].receiveNumCells(blues);
        players[1].receiveNumCells(reds);
    }

    private GameController(){
        players[0] = new Player();
        players[1] = new Player();

    }

    public static synchronized GameController getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new GameController();
        }
        return uniqueInstance;
    }

    public void startGame(){

        //1. Player Move
        //2. update
        //3. next generation

    }



}

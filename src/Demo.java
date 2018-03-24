import java.util.Scanner;

/**
 * Created by jszeligowski on 2018-03-24.
 */
public class Demo
{
    public static void main( String[] args )
    {
        GameBoard gameBoard = new GameBoard();
        Scanner scanner = new Scanner( System.in );

        boolean gameEnded = false;
        boolean currentPlayer = false;
        char playerSign = 'X';
        System.out.println("Start player "+ playerSign);
        while( !gameEnded )
        {
            System.out.println( "Now move player " + playerSign + " Enter move position {0-8}" );
            String position = scanner.next();

            if( gameBoard.isValidPosition( position, playerSign ) )
            {
                boolean isWinner=gameBoard.add( position, playerSign );
                currentPlayer = !currentPlayer;
                gameEnded = isWinner;
                gameBoard.printBoard();
                if(gameEnded){
                    break;
                }

                playerSign = !currentPlayer ? 'X' : 'O';

            } else{
                System.out.println("Bad move position. Enter another");
            }
        }
    }
}

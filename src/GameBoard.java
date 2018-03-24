/**
 * Created by jszeligowski on 2018-03-24.
 */
public class GameBoard
{
    private char[][] board = new char[ 3 ][ 3 ];

    public boolean isValidPosition( String position, char playerSign )
    {
        int number = Integer.parseInt( position );
        int row = number / 3;
        int col = number % 3;
        return board[ row ][ col ] == 0;
    }

    public boolean add( String position, char playerSign )
    {
        int number = Integer.parseInt( position );
        int row = number / 3;
        int col = number % 3;
        board[ row ][ col ] = playerSign;
        return isWinningMove( playerSign );
    }

    public boolean isWinningMove(char playerSign){
        return checkColums( playerSign ) || checkRows( playerSign ) || checkDiagonals( playerSign );
    }

    public boolean checkRows( char playerSign )
    {
        return
            (board[ 0 ][ 0 ] == playerSign && board[ 1 ][ 0 ] == playerSign && board[ 2 ][ 0 ] == playerSign)
                ||
                (board[ 0 ][ 1 ] == playerSign && board[ 1 ][ 1 ] == playerSign
                    && board[ 2 ][ 1 ] == playerSign) ||
                (board[ 0 ][ 2 ] == playerSign && board[ 1 ][ 2 ] == playerSign
                    && board[ 2 ][ 2 ] == playerSign);
    }

    public boolean checkColums( char playerSign )
    {
        return
            (board[ 0 ][ 0 ] == playerSign && board[ 0 ][ 1 ] == playerSign && board[ 0 ][ 2 ] == playerSign)
                ||
                (board[ 1 ][ 0 ] == playerSign && board[ 1 ][ 1 ] == playerSign
                    && board[ 1 ][ 2 ] == playerSign) ||
                (board[ 2 ][ 0 ] == playerSign && board[ 2 ][ 1 ] == playerSign
                    && board[ 2 ][ 2 ] == playerSign);
    }

    public boolean checkDiagonals( char playerSign )
    {
        return
            (board[ 0 ][ 0 ] == playerSign && board[ 1 ][ 1 ] == playerSign && board[ 2 ][ 2 ] == playerSign)
                ||
                (board[ 0 ][ 2 ] == playerSign && board[ 1 ][ 1 ] == playerSign
                    && board[ 2 ][ 0 ] == playerSign);
    }

    public void printBoard()
    {
        //oxo
        //-x-
        //o--

        for( int i = 0; i < 3; i++ )
        {
            for( int j = 0; j < 3; j++ )
            {
                System.out.print( board[ i ][ j ] );

                if( j < 2 )
                {
                    System.out.print( " | " );
                }
            }
            if( i != 2 )
            {
                System.out.println( "\n--------" );
            }
        }
    }

}

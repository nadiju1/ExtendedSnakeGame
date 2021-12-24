import java.awt.*;

public class SnakeGameDriver {

    @SuppressWarnings( "resource" )
    public static void main( String[] args ) {
        Point playerPosition = new Point( 10, 9 );
        Point snakePosition = new Point( 30, 2 );
        Point goldPosition = new Point( 6, 6 );
        Point doorPosition = new Point( 0, 5 );
        boolean rich = false;

        while ( true ) {

            // Raster mit Figuren zeichnen

            for ( int y = 0; y < 20; y++ ) {
                for ( int x = 0; x < 80; x++ ) {
                    Point p = new Point( x, y );
                    if ( playerPosition.equals( p ) )
                        System.out.print( '&' );
                    else if ( snakePosition.equals( p ) )
                        System.out.print( 'S' );
                    else if ( goldPosition.equals( p ) )
                        System.out.print( '$' );
                    else if ( doorPosition.equals( p ) )
                        System.out.print( '#' );
                    else System.out.print( '.' );
                }
                System.out.println();
            }

            // Status feststellen

            if ( rich && playerPosition.equals( doorPosition ) ) {
                System.out.println( "Gewonnen!" );
                return;
            }
            if ( playerPosition.equals( snakePosition ) ) {
                System.out.println( "ZZZZZZZ. Die Schlange hat dich!" );
                return;
            }
            if ( playerPosition.equals( goldPosition ) ) {
                rich = true;
                goldPosition.setLocation( -1, -1 );
            }

            // Konsoleneingabe und Spielerposition verändern

            switch ( new java.util.Scanner( System.in ).next() ) {
                // Spielfeld ist im Bereich 0/0 .. 79/19
                case "h" : playerPosition.y = Math.max(  0, playerPosition.y - 1 ); break;
                case "t" : playerPosition.y = Math.min(  19, playerPosition.y + 1 ); break;
                case "l" : playerPosition.x = Math.max(  0, playerPosition.x - 1 ); break;
                case "r" : playerPosition.x = Math.min( 79, playerPosition.x + 1 ); break;
            }

            // Schlange bewegt sich Richtung Spieler

            if ( playerPosition.x < snakePosition.x )
                snakePosition.x--;
            else if ( playerPosition.x > snakePosition.x )
                snakePosition.x++;
            if ( playerPosition.y < snakePosition.y )
                snakePosition.y--;
            else if ( playerPosition.y > snakePosition.y )
                snakePosition.y++;
        } // end while
    }
}


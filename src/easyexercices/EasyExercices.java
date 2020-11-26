package easyexercices;


public class EasyExercices {

    public static void main(String[] args) {
//use methods here
    String  Structure="###########E########"
                    + "#...#######.#####.##"
                    + "#.#.#######.#..##.##"
                    + "#...........##.....#"
                    + "#.############.##.##"
                    + "#.########.###.##.##"
                    + "#.####.....###.##..#"
                    + "#......###..S..#####"
                    + "######.#############"
                    + "####################"; 
   
    Maze Laberinto = new Maze(Structure);
    Laberinto.isway();
    

    }
    
}

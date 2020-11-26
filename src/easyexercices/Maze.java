/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyexercices;

/**
 *
 * @author Carlos
 */
public class Maze {
    
    char[][] Maze;
    
    public Maze(String Structure){
            //20 x 10
            Maze = new char[22][12];
            for (int i = 0;i<22;i++){
                for (int k = 0; k<12;k++){
                    Maze[i][k]='.';
                }
            }
          for (int i = 0;i<22;i++){
                
                    Maze[i][0]='#';
                    Maze[i][11]='#';
            }
          for (int k = 0; k<12;k++){
                    Maze[0][k]='#';
                    Maze[21][k]='#';
                }
          if (Structure.length()==200){
              int t = 0;
                          for (int k = 0; k<10;k++){
                                for (int i = 0;i<20;i++){
                                      Maze[i+1][k+1]=Structure.charAt(t);
                                      t++;
                                 }
            }
          }else{
              System.out.println("Estructura de String inadecuada. Laberinto no iniciado");
          }
          
    }
    
    public void ShowStatus(){
        for (int i = 0;i<22;i++){
                for (int k = 0; k<12;k++){
                    System.out.print(Maze[i][k]);
                }
                   System.out.println("");
            }
    }
    public void ShowStatus(char[][] aux_maze){
        for (int i = 0;i<22;i++){
                for (int k = 0; k<12;k++){
                    System.out.print(aux_maze[i][k]);
                }
                   System.out.println("");
            }
    }
    
    class Position{
        int x,y;
        public Position(int posx,int posy){
            x=posx;
            y=posy;
        }
        
        public Position(){
            x=0;
            y=0;
        }
        
        public void getStart(){
        for (int k = 0; k<12;k++){
                                for (int i = 0;i<22;i++){
                                      if(Maze[i][k]=='S'){
                                          x=i;
                                          y=k;
                                         
                                      }
                                      
                                 }
            }
        }
    
        public void chpos(int posx, int posy){
            x=posx;
            y=posy;
        }
    }
    
    char Move(Position initialPosition, char Direction, char[][] aux_Maze){
        switch(Direction){
            case 'u':
                if(aux_Maze[initialPosition.x][initialPosition.y+1]=='.' || aux_Maze[initialPosition.x][initialPosition.y+1]=='E'){
                    return aux_Maze[initialPosition.x][initialPosition.y+1];
                }
                break;
            case 'd':
                if(aux_Maze[initialPosition.x][initialPosition.y-1]=='.' || aux_Maze[initialPosition.x][initialPosition.y-1]=='E'){
                    return aux_Maze[initialPosition.x][initialPosition.y-1];
                }
                break;
            case 'r':
                if(aux_Maze[initialPosition.x+1][initialPosition.y]=='.' || aux_Maze[initialPosition.x+1][initialPosition.y]=='E'){
                    return aux_Maze[initialPosition.x+1][initialPosition.y];
                }
                break;
            case 'l':
                if(aux_Maze[initialPosition.x-1][initialPosition.y]=='.' || aux_Maze[initialPosition.x-1][initialPosition.y]=='E'){
                    return aux_Maze[initialPosition.x-1][initialPosition.y];
                }
                break;
            default:
                return '#';
                
    }
            return '#';
    }
    
   void testingmovement(){
       Position pos = new Position();
       pos.getStart();

              

   }



   boolean isway(){
       Position pos = new Position();
       pos.getStart();
       char[][] aux_maze=Maze;
       
       return isway(aux_maze,pos);
   }
    
   boolean isway(char[][] mazed,Position pos){
       
       char[][] aux_maze = new char[22][12];
       
       for (int i =0;i<aux_maze.length;i++){
           for (int k = 0 ; k<aux_maze[i].length;k++){
               aux_maze[i][k]=mazed[i][k];
           }
       }
   
       aux_maze[pos.x][pos.y]='x';   
       
       
       if(Move(pos,'u',aux_maze)=='E' || Move(pos,'d',aux_maze)=='E' ||Move(pos,'r',aux_maze)=='E'|| Move(pos,'l',aux_maze)=='E'){
           System.out.println("Finalizado");
           ShowStatus(aux_maze);
           return true;
           //its finished?
           
           
           
       } else {
       //mark current posittion as visited
       
      
       Position nextpos = new Position(pos.x,pos.y+1);
       
       if(Move(pos,'u',aux_maze)=='.' && isway(aux_maze,nextpos)){
           
           return true;
       
       }
           
        nextpos.chpos(pos.x,pos.y-1);
        if(Move(pos,'d',aux_maze)=='.' && isway(aux_maze,nextpos)){

            return true;

           }

        nextpos.chpos(pos.x+1,pos.y);
        if(Move(pos,'r',aux_maze)=='.' && isway(aux_maze,nextpos)){

        return true;

                }

        nextpos.chpos(pos.x-1,pos.y);   
        if(Move(pos,'l',aux_maze)=='.' && isway(aux_maze,nextpos)){

        return true;
        }
                }
             


        
   
       return false;
   }
    
}


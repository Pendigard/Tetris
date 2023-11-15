package grid;

public class Grid {
    private int lenght;
    private int width;
    private  Case[][] grd;

    public Grid(int lenght, int width){
        this.lenght = lenght;
        this.width = width;
        grd = new Case[lenght][width];

        for(int i=0;i < lenght; i++){
            for(int j=0;j < width; j++){
                grd[i][j] = new Case();
            }
        }
    }
}

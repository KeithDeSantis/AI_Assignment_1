public enum Direction {
    N(0,1),S(0,-1),E(1,0),W(-1,0);

    int i,j;


    Direction(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

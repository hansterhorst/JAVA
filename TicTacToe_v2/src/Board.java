public class Board {

    private Field[] board;

    public Board(Field[] board){
        this.board = board;
    }

    public void createBoard(){
        for(int i = 0; i < board.length; i++){
            board[i] = new Field(Integer.toString(i + 1));
            System.out.print(board[i].getField());

            if((i + 1) % 3 == 0) {
                if(!(i == board.length)){
                    System.out.println("\n---------");
                }
            } else {
                System.out.print(" | ");
            }

        }
    }

    public void setBoard(int index, Player currentPlayer){
        board[index].setField(currentPlayer.getSymbol());
        for(int i = 0; i < board.length; i++){
            System.out.print(board[i].getField());

            if((i + 1) % 3 == 0) {
                if(!(i == board.length)){
                    System.out.println("\n---------");
                }
            } else {
                System.out.print(" | ");
            }
        }

    }


}

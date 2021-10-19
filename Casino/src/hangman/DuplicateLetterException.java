package hangman;

public  class DuplicateLetterException extends RuntimeException{
   
   public DuplicateLetterException(char letter){
      super(String.format("Sorry, this letter %s is already used. Try again.", letter));
   }
}

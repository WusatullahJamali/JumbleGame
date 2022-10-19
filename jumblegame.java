import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class jumblegame {

    private static final String[] WORDS_DATABASE = new String[]{
            "developer", "mehran", "programmer", "software", "javascript", "mongodb","university","python","django","coding"
    };
    public static void main(String[] args) {
        jumblegame jg = new jumblegame();
        jg.startGame();
    }

    private void startGame() {
        run();
        }

    public String getUserGuess() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Please type in the original word: ");
        return sn.nextLine();
    }

    public String selectRandomWord() {
        int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);
        return WORDS_DATABASE[rPos];
    }

    public String getShuffledWord(String original) {
        String shuffledWord = original;
        int wordSize = original.length();
        int shuffleCount = 10;
        for (int i = 0; i < shuffleCount; i++) {
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord, position1, position2);
        }
        return shuffledWord;
    }

    private String swapCharacters(String shuffledWord, int position1, int position2) {
        char[] charArray = shuffledWord.toCharArray();
        // Replace with a "swap" function, if desired:
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;
        return new String(charArray);
    }
    public void run(){
        for (int i=0;i<=4; i++){
            int numberOfGuesses = 0;
            String original = selectRandomWord();
            String shuffled = getShuffledWord(original);
            boolean gameOn = true;
            while (gameOn) {
                System.out.println("Shuffled word is: " + shuffled );
                numberOfGuesses++;
                String userGuess = getUserGuess();
                if (original.equalsIgnoreCase(userGuess)) {
                    System.out.println("Congratulations! You found the word in " + numberOfGuesses + " guesses");
                    gameOn = false;
                } else {
                    System.out.println("Sorry, Wrong answer");
                    gameOn = false;
                }
            }
        }
    }
}

public class CribbageShow {

    private List<Card> cards;
    private int score;

    public CribbageShow(List<Card> cards, int score) {
        this.cards = cards;
        this.score = score;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }
}

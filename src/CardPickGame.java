public class CardPickGame {
	private int maxBetCoin = 100;
	private int deckSetCount = 2;
	private int posessionCoin;
	
	public CardPickGame(int posessionCoin) {
		this.posessionCoin = posessionCoin;
		
	}
	
	public void execute() {
		getCard();
	}
	
	private int getCard() {
		int[][]decks = new int [deckSetCount][];
		int[] deck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		for (int i = 0; i < deckSetCount; i++) {
			decks[i]= deck;
		}
		
		int firstNum = 0;
		int secondNum = 0;
		
		firstNum = GameUtils.getRandomInt(deckSetCount);
		secondNum = GameUtils.getRandomInt(deck.length);
		int firstCard = decks[firstNum][secondNum];
		
		firstNum = GameUtils.getRandomInt(deckSetCount);
		secondNum = GameUtils.getRandomInt(deck.length);
		int secondCard = decks[firstNum][secondNum];
		
		if (firstCard == secondCard) {
			getCard();
		}
		
		int total = firstCard + secondCard;
		System.out.println("Cards drawn are " + firstCard + " and " + secondCard + ", total is " + total);
		return total;
	}
}



























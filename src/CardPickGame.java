import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		List<List<Integer>> setDeck = new ArrayList<List<Integer>>();
		List<Integer> onePair = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		for (int i = 0; i < this.deckSetCount; i++) {
			setDeck.add(i, onePair);
		}
		
		int randNumA1;
		int randNumA2;
		int randNumB1;
		int randNumB2;
		
		while (true) {
			randNumA1 = GameUtils.getRandomInt(2);
			randNumA2 = GameUtils.getRandomInt(10);
			randNumB1 = GameUtils.getRandomInt(2);
			randNumB2 = GameUtils.getRandomInt(10);
			
			if (!(randNumA1 == randNumB1 && randNumA2 == randNumB2)) {
				break;
			}
		}
		
		
		int cardA = setDeck.get(randNumA1).get(randNumA2);
		int cardB = setDeck.get(randNumB1).get(randNumB2);
		int userNumSum = cardA + cardB;
		
		
		System.out.println("Cards drawn are " + cardA + " and " + cardB + ", total is " + userNumSum);
		
		return userNumSum;
	}
}
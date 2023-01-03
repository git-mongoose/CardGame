import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardPickGame {
	private int maxBetCoin = 100;
	private int deckSetCount = 2;
	private int possessionCoin;
	
	public CardPickGame(int posessionCoin) {
		this.possessionCoin = posessionCoin;
		
	}
	
	public int execute() {
		while(true) {
			if (this.possessionCoin == 0) {
				return this.possessionCoin;
			}
			
			while (true) {
				System.out.println("You have " + this.possessionCoin + "Coin, Start the game? y / n");
				String startValue = GameUtils.getInputString();
				if (startValue.equals("y")) {
					break;
				} else if (startValue.equals("n")) {
					return this.possessionCoin;
				} else {
					System.out.println("Please enter y or n");
				}
			}
			
			int ableBetCoin = Math.min(this.maxBetCoin, this.possessionCoin);
			System.out.println("Please bet Coin 1 ~ " + ableBetCoin);
			
			int userBetCoin = 0;
			while (true) {
				userBetCoin = GameUtils.getInputInt();
				if (userBetCoin > 0 && userBetCoin <= ableBetCoin) {
					break;
				}
			}
			
			this.possessionCoin -= userBetCoin;
			
			int userCard = this.getCard();
			boolean isWinner = this.judgeCard(userCard);
			int getCoin = 0;
			if (isWinner) {
				getCoin = userBetCoin * 2;
				System.out.println("You Win! Get " + getCoin + "Coin!");
				this.possessionCoin += getCoin;
			}
			if (getCoin >= 1) {
				System.out.println("You got " + getCoin + "Coin !!");
			}
			
		}
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
	
	private boolean judgeCard(int getCardResult) {
		return (getCardResult >= 11) ? true : false;
	}
	
}
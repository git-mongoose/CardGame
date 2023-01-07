import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighAndLowGame {
	private int earnedCoinCount;
	private int maxWinCoin = 10000;
	private int deckSetCount;
	
	public HighAndLowGame(int earnedCoinCount, int deckSetCount) {
		this.earnedCoinCount = earnedCoinCount;
		this.deckSetCount = deckSetCount;
	}
	
	public int execute() {
		List<Integer> cardList = new ArrayList<Integer>();
		cardList = this.getCard(cardList);
		
		while (true) {
			if (this.earnedCoinCount > this.maxWinCoin) {
				return this.earnedCoinCount;
			}
			
			System.out.println("Your winCoin is " + earnedCoinCount);		
			
			while (true) {
				System.out.println("Playing High And Low? y/n");
				String startValue = GameUtils.getInputString();
				if (startValue.equals("n")) {
					return earnedCoinCount;
				} else if (startValue.equals("y")) {
					break;
				} else {
					System.out.println("Input error..Please retyrpe!");
				}			
			}
			
			boolean pickChoice = true;
			while (true) {
				System.out.println("High or low? h/l");
				String userChoice = GameUtils.getInputString();
				if (userChoice.equals("h")) {
					break;
				} else if (userChoice.equals("l")) {
					pickChoice = false;
					break;
				} else {
					System.out.println("Input error..Please retyrpe!");
				}
			}
			cardList = this.getCard(cardList);
			boolean isWinner = this.judgeCard(cardList, pickChoice);
			
			if (isWinner) {
				this.earnedCoinCount *= 2;
			} else {
				this.earnedCoinCount = 0;
			}
			
			if (this.earnedCoinCount == 0) {
				return this.earnedCoinCount;
			}
			
			System.out.println("You got " + this.earnedCoinCount + "Coin !!");
		}
	}
	
	private List<Integer> getCard(List<Integer> cardList) {
		List<List<Integer>> setDeck = new ArrayList<List<Integer>>();
		List<Integer> onePair = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		for (int i = 0; i < this.deckSetCount; i++) {
			setDeck.add(i, onePair);
		}
		
		int cardA;
		
		while (true) {
			int randNumA1 = GameUtils.getRandomInt(2);
			int randNumA2 = GameUtils.getRandomInt(10);
			cardA = setDeck.get(randNumA1).get(randNumA2);
			
			
			int count = 0;
			for (int value : cardList) {
				if (cardA == value) {
					count++;
				}
			}
			if (count < this.deckSetCount) {
				break;
			}
		}
		
		cardList.add(cardA);
		int lastIdx = cardList.size() - 1;
		int showValue = cardList.get(lastIdx);
		
		System.out.println("pick card --" + showValue + "--");
		return cardList;
	}
	
	private boolean judgeCard(List<Integer> cardList, boolean pickChoice) {
		int num = cardList.size();
		int lastCard = cardList.get(num - 1);
		int penultimateCard = cardList.get(num - 2);
		
		if (lastCard == penultimateCard) {
			return false;
		}
		
		boolean flg = (lastCard > penultimateCard) ? true : false;
		if (pickChoice == flg) {
			return true;
		}
		return false;
	}
}
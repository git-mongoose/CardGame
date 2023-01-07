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
	
	public void execute() {
		List<Integer> cardList = new ArrayList<Integer>();
		cardList = getCard(cardList);
		System.out.println(cardList);
		
		cardList = getCard(cardList);
		System.out.println(cardList);
		boolean result = judgeCard(cardList, true);
		System.out.println(result);
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
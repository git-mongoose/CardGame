
public class CardPickGame {
	private int maxBetCoin = 100;
	private int deckSetCount = 2;
	private int posessionCoin;
	
	public CardPickGame(int posessionCoin) {
		this.posessionCoin = posessionCoin;
	}
	
	public void execute() {
	}
	
	private boolean judgeCard(int getCardResult) {
		if (getCardResult >= 11) {
			return true;
		} else {
			return false;
		}
	}
	
}
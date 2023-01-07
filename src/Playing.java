public class Playing {
	public static void main(String[] args) {
		String username = "";
		int possessionCoin = 1000;
		System.out.println("Welcome !");
		System.out.println("Enter your username");
		
		while (true) {
			username = GameUtils.getInputString();
	
			if (GameUtils.checkPattern(username)) {
				break;
			}

			System.out.println("Does not match condition of the username");
		}
		System.out.println("Hello " + username);
		CardPickGame cardPickGame = new CardPickGame(possessionCoin);
		int getCoin = cardPickGame.execute();
		HighAndLowGame highAndLowGame = new HighAndLowGame(getCoin, 2);
		highAndLowGame.execute();
		
		System.out.println(username + " Possession : " + possessionCoin + "Coin");
	}
}

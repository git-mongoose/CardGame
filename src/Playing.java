public class Playing {
	public static void main(String[] args) {
		String username = "";
		int possessionCoin = 1000;
		System.out.println("Welcome !");
		System.out.println("Enter your username");
		while (true) {
			username = GameUtils.getInputString();
			boolean result = GameUtils.checkPattern(username);
			if (result == false) {
				System.out.println("Does not match condition of the username");
			} else {
				break;
			}			
		}
		System.out.println("Hello " + username);
		CardPickGame cardPickGame = new CardPickGame(possessionCoin);
		possessionCoin = cardPickGame.execute();
		
		System.out.println(username + " Possession : " + possessionCoin + "Coin");
	}
}

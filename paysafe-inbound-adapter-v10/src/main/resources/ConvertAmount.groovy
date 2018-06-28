class ConvertAmount {
      public getAmount(String amount, String currency){

            if(amount.contains(".")) {
                  String[] amountArray= amount.split("\\.")
				  if(amountArray[1].length()==1){
					  amount= amountArray[0]+amountArray[1]+"0"
					  return amount
				  }
                  amount= amountArray[0]+amountArray[1]
            }
            else {
                  amount= amount+"00"
            }
            return amount
      }
      public getAmountResponse(String amount){
            amount=new StringBuffer(amount).insert(amount.length()-2, ".").toString();
            amount=Double.parseDouble(amount)
            return amount
      }
}

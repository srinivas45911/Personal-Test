import org.mule.api.MuleContext
import org.mule.context.DefaultMuleContextFactory
import org.mule.api.MuleMessage
class ClientTokenDetails {
      public getApikeyAndMerchantId(String legalEntity, String currency, MuleContext muleContext,MuleMessage message){
            if (muleContext.getRegistry().get("merchant_information")[currency] !=null && currency.equals(muleContext.getRegistry().get("merchant_information")[currency].Currency)){
            if((currency.equals(muleContext.getRegistry().get("merchant_information")[currency].Currency)) && (legalEntity.equals(muleContext.getRegistry().get("merchant_information")[currency].LegalEntity))) {
                  message.setInvocationProperty('Account_Id',muleContext.getRegistry().get("merchant_information")[currency].MerchantId)
                       message.setInvocationProperty('Apikey',"Basic "+muleContext.getRegistry().get("merchant_information")[currency].APIKey)
                  }  else {
                        throw new IllegalArgumentException("LegalEntityAndCurrencyMismatch");
                  }
            }
            else     {
                  throw new IllegalArgumentException("LegalEntityAndCurrencyMismatch"+"Invalid currnecy");
            }
      }
     public getPreAuthAmount(String legalEntity, String currency, MuleContext muleContext){
		String preAuthAmount;
		if (muleContext.getRegistry().get("merchant_information")[currency] !=null && currency.equals(muleContext.getRegistry().get("merchant_information")[currency].Currency)){
			if((currency.equals(muleContext.getRegistry().get("merchant_information")[currency].Currency)) && (legalEntity.equals(muleContext.getRegistry().get("merchant_information")[currency].LegalEntity))) {
				preAuthAmount= muleContext.getRegistry().get("merchant_information")[currency].PreAuthAmount
			}  else{
				throw new IllegalArgumentException("LegalEntityAndCurrencyMismatch");
			}
		}
		else     {
                  throw new IllegalArgumentException("LegalEntityAndCurrencyMismatch"+"Invalid currnecy");
            }
		return preAuthAmount;
		
	}
}

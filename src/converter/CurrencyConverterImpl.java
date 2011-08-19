package converter;

import exceptions.UnknownCurrencyException;

public class CurrencyConverterImpl implements CurrencyConverter {

    @Override
    public double USD2EUR(double USD) {
        return USD * 1.4;
    }

    @Override
    public double EUR2USD(double EUR) {
        return EUR * 0.7;
    }

    @Override
    public String getCurrencySymbol(String currencyCode) throws UnknownCurrencyException{
        if("USD".equals(currencyCode)) {
            return "$";
        }
        if("EUR".equals(currencyCode)) {
            return "€";
        } else {
            throw new UnknownCurrencyException(currencyCode + " is not a available currency code");
        }
    }

}

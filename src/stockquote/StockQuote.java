package stockquote;

import org.osoa.sca.annotations.Remotable;

import exceptions.UnknownCurrencyException;
import exceptions.UnknownStockException;

@Remotable
public interface StockQuote {
    public String getStockQuote(String company, String currency) throws UnknownCurrencyException, UnknownStockException;
}

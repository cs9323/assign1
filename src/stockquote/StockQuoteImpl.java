package stockquote;

import java.util.HashMap;
import java.util.Random;
import org.osoa.sca.annotations.Reference;
import converter.CurrencyConverter;
import exceptions.UnknownCurrencyException;
import exceptions.UnknownStockException;

public class StockQuoteImpl implements StockQuote {

    @Reference
    protected CurrencyConverter converter;

    // Stores a bunch of stocks and corresponding stock quote.
    protected HashMap<String, Double> stocks;

    protected String[] stockCodes = { "COH", "RIO", "BHP", "LEI", "CPB" };

    protected final double MAX_PRICE = 100.0;

    public StockQuoteImpl() {

        Random random = new Random();

        stocks = new HashMap<String, Double>();
        for (String stockCode : stockCodes) {
            Double stockQuote = Math.abs(random.nextDouble() * MAX_PRICE);
            stocks.put(stockCode, stockQuote);
        }
    }

    @Override
    public String getStockQuote(String company, String currency)
            throws UnknownStockException, UnknownCurrencyException {

        String result = new String();
        String result_tail = new String();

        try {
            if (!stocks.containsKey(company))
                throw new UnknownStockException(company
                        + " is not an available code.");
            Double stockQuote = stocks.get(company);
            if ("EUR".equals(currency)) {
                result = converter.getCurrencySymbol(currency) + stockQuote * 1.3;
                result_tail = converter.getCurrencySymbol("USD") + stockQuote;
            } else if("USD".equals(currency)) {
                result = converter.getCurrencySymbol(currency) + stockQuote;
                result_tail = converter.getCurrencySymbol("EUR") + stockQuote * 1.3;
            } else {
                throw new UnknownCurrencyException(currency + " is not an available currency");
            }
            return result + ",   " + result_tail;
        } catch (UnknownCurrencyException e) {
            System.out.println(e.getMessage());
        }

        return "Not applicable";
    }

}

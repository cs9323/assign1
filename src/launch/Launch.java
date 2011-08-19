package launch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.tuscany.sca.host.embedded.SCADomain;

import stockquote.StockQuote;

public class Launch {
    public static void main(String[] args) {

        SCADomain scaDomain = SCADomain.newInstance("stockquote.composite");
        StockQuote service = scaDomain.getService(StockQuote.class,
                "StockQuoteComponent");

        String input = new String();

        BufferedReader instreamReader = new BufferedReader(
                new InputStreamReader(System.in));

        
        /*
         * for input, we have company code: "COH", "RIO", "BHP", "LEI", "CPB"
         * ........., ........currency code: "USD", "EUR"
         * should be in the right order, and separated by a single comma, no trailing spaces
         * 
         */
        try {
            while ((input = instreamReader.readLine()) != null) {
                String[] tokens = input.split(",");
                if(tokens.length != 2) {
                    System.out.println("Wrong input, it should be like \"BHP,USD\".");
                    continue;
                }
                System.out.println(service.getStockQuote(tokens[0].toUpperCase(), tokens[1].toUpperCase()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scaDomain.close();

    }
}

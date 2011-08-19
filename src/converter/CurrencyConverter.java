package converter;

import org.osoa.sca.annotations.Remotable;

import exceptions.UnknownCurrencyException;

@Remotable
public interface CurrencyConverter {
    public double USD2EUR(double USD);
    public double EUR2USD(double EUR);
    public String getCurrencySymbol(String currencyCode) throws UnknownCurrencyException;
}

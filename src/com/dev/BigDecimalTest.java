package testebig;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Teste7 {

    public static void main(String[] args) {

        BigDecimal qtdDestinada = new BigDecimal("0.00080");
        BigDecimal getNumeroFatorConversao = new BigDecimal("0.005");

        BigDecimal result = qtdDestinada.divide(getNumeroFatorConversao, new MathContext(16, RoundingMode.DOWN));
        BigDecimal result2 = qtdDestinada.divide(getNumeroFatorConversao, MathContext.DECIMAL64);
        BigDecimal valorConvertido = BigDecimalUtil.toBigDecimal(result.toPlainString());

        int scale = 2;
        BigDecimal valor3 = qtdDestinada.divide(getNumeroFatorConversao, scale, RoundingMode.UNNECESSARY);

        System.out.println("result " + result);
        System.out.println("result2 " + result2);
        System.out.println("valorConvertido " + valorConvertido);
        System.out.println("valor3 " + valor3);

    }
}

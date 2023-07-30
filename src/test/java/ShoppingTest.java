import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingTest {

    private static final String APPLES = "Apples";
    private static final String BANANAS = "Bananas";
    private static final String MELONS = "Melons";
    private static final String LIMES = "Limes";

    @Test
    void calculatePriceTest() {
        List<String> shoppingList = List.of("Melons", "Melons", "Melons");
        Assertions.assertEquals(new BigDecimal(100), calculatePrice(shoppingList));
    }

    private static BigDecimal calculatePrice(List<String> shoppingList) {
        if(shoppingList == null || shoppingList.isEmpty()){
            return new BigDecimal(0);
        }
        BigDecimal price = new BigDecimal(0);
        long appleSum = shoppingList.stream()
                .filter(item -> item.equals(APPLES))
                .count();
        price = price.add(BigDecimal.valueOf(appleSum * 35L));
        long bananaSum = shoppingList.stream()
                .filter(item -> item.equals(BANANAS))
                .count();
        price = price.add(BigDecimal.valueOf(bananaSum * 20L));
        long melonsSum = shoppingList.stream()
                .filter(item -> item.equals(MELONS))
                .count();
        price = price.add(BigDecimal.valueOf(melonsSum % 2 == 0 ? (melonsSum / 2) * 50L : (melonsSum / 2) * 50L + 50L));
        long limesSum = shoppingList.stream()
                .filter(item -> item.equals(LIMES))
                .count();
        price = price.add(BigDecimal.valueOf(limesSum % 3 == 0 ? (limesSum / 3) * 30L : (limesSum / 3) * 30L + (limesSum % 3 * 15L)));
        return price;
    }
}

package Tests_Refactorizat;

import ObjectData.EcommerceObject;
import Pages.EcommercePage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

// Testul E-commerce refactorizat.
public class EcommerceTest extends Test_Base_Page {


    private Map<String, EcommerceObject> ecommerceObjectMap;

    @Test
    public void metodaTest() {

        // Citim datele din fisierul XML.
        ecommerceObjectMap = XmlDataLoader.loadData("src/test/resources/EcommerceData.xml", EcommerceObject.class);

        // Preluam datele din dataSet_1.
        EcommerceObject data = ecommerceObjectMap.get("dataSet_1");

        // Verificam daca datele au fost citite.
        Assert.assertNotNull(data, "Datele Ecommerce nu au fost citite din XML!");

        // Deschidem pagina de E-commerce.
        getDriver().get("https://www.qapractice.com/practice-ecommerece-website");

        // Cream obiectul EcommercePage.
        EcommercePage ecommercePage = new EcommercePage(getDriver());

        // 1. CANTITATE
        ecommercePage.enterQuantity(data.getQuantity());

        // 2. ADD TO CART
        ecommercePage.clickAddToCart();

        // 3. DESCHIDEM COSUL
        Assert.assertTrue(ecommercePage.isCartDisplayed());

        ecommercePage.clickCart();

        // 4. PROCEED TO BUY
        ecommercePage.clickProceedToBuy();

        // 5. SHIPPING ADDRESS
        ecommercePage.enterName(data.getName());

        ecommercePage.enterStreet(data.getStreet());

        ecommercePage.enterCity(data.getCity());

        ecommercePage.enterState(data.getState());

        ecommercePage.enterZip(data.getZip());

        // Verificam numele introdus.
        Assert.assertEquals(ecommercePage.getNameValue(), data.getName());

        // Salvam adresa.
        ecommercePage.clickSaveAddress();

        // 6. PAYMENT DETAILS
        ecommercePage.enterCardNumber(data.getCardNumber());

        ecommercePage.enterExpiry(data.getExpiry());

        ecommercePage.enterCvv(data.getCvv());

        // Verificam numarul cardului.
        Assert.assertEquals(ecommercePage.getCardNumberValue(), data.getCardNumber());

        // 7. BUY NOW
        Assert.assertTrue(ecommercePage.isBuyNowDisplayed());

        ecommercePage.clickBuyNow();

        // 8. VERIFICAM COMANDA finalizata.
        Assert.assertEquals(ecommercePage.getOrderSuccessMessage(), "Order Successful!");
    }

}

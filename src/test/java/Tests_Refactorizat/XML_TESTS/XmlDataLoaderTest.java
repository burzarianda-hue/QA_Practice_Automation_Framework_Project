package Tests_Refactorizat.XML_TESTS;


import ObjectData.LoginObject;
import XmlReader.XmlDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class XmlDataLoaderTest {

    private Map<String, LoginObject> loginObjectMap;

    @Test
    public void citireLoginDataTest() {

        loginObjectMap = XmlDataLoader.loadData("src/test/resources/LoginData.xml", LoginObject.class);
        LoginObject data = loginObjectMap.get("dataSet_1");

        Assert.assertNotNull(data, "Datele nu au fost citite din XML!");

        Assert.assertEquals(data.getEmail(), "user@premiumbank.com");
        Assert.assertEquals(data.getPassword(), "Bank@123");

        System.out.println("Email citit din XML: " + data.getEmail());
    }

}


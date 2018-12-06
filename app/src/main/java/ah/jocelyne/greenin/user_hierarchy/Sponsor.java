package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class Sponsor extends RegisteredUser implements Role{

    private double amountUSD;
    private String country;
    private int cardNumber;
    private String expiryDate;
    private int securityCode;
    private String StreetAddress;
    private String optionalAddressLine;
    private String city, state, email, phoneNumber;

    public Sponsor(String firstName, String lastName, String email, String hashedPassword, String salt, String role)
    {
        super(firstName, lastName, email, hashedPassword, salt, role);

        amountUSD = 0.0;
        country = "";
        cardNumber = 00000000000000;
        expiryDate = "00/00/00";
        securityCode = 000;
        StreetAddress = "";
        optionalAddressLine = "";
        city = state = email = phoneNumber = 0;
    }

    public void donateAmount() {}
    public void invokeMyFunctions()
    {
        donateAmount();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}

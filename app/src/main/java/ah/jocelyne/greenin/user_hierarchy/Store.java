package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class Store extends RegisteredUser implements Role{

    public Store(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        lastName = ""; //Store has no last name. Assigned by default.
        role = "Store";
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void addStoreDescription() {    }
    public void addStoreImageToDescription() {    }
    public void removeStoreImageToDescription() {    }
    public void editStoreDescription() {}
    public void deleteStoreDescription() {}


    public void invokeMyFunctions()
    {
        addStoreDescription();
        addStoreImageToDescription();
        removeStoreImageToDescription();
        editStoreDescription();
        deleteStoreDescription();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}

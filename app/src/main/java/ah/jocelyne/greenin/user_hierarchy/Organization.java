package ah.jocelyne.greenin.user_hierarchy;

public class Organization implements Role extends RegisteredUser{

    public Organization(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        lastName = ""; //Organization has no last name. Assigned by default.
        role = "Organization";
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void addOrganizationDescription() {    }
    public void addOrganizationImageToDescription() {    }
    public void removeOrganizationImageToDescription() {    }
    public void editOrganizationDescription() {}
    public void deleteOrganizationDescription() {}

    public void invokeMyFunctions()
    {
        addOrganizationDescription();
        addOrganizationImageToDescription();
        removeOrganizationImageToDescription();
        editOrganizationDescription();
        deleteOrganizationDescription();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}

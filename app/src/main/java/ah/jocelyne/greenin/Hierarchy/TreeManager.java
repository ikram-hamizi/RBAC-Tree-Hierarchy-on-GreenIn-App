package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class TreeManager {

    private static TreeNode createTree()
    {
        //Level root - 1:
        TreeNode root = new TreeNode(new Admin ());

        //Level 1:
        TreeNode node1 = root.addChild(new TreeNode(new Manager ()));
        TreeNode node2 = root.addChild(new TreeNode(new Volunteer()));
        TreeNode node3 = root.addChild(new TreeNode(new Sponsor()));

        //Level 2:
        TreeNode node11 = node1.addChild(new TreeNode(new ProjectManager()));
        TreeNode node12 = node1.addChild(new TreeNode(new Journalist()));
        TreeNode node13 = node1.addChild(new TreeNode(new CustomerService()));

        TreeNode node21 = node2.addChild(new TreeNode(new Guest()));

        TreeNode node31 = node3.addChild(new TreeNode(new Store()));
        TreeNode node32 = node3.addChild(new TreeNode(new Organization()));

        //Level 3:
        TreeNode node111 = node11.addChild(new TreeNode(new ProjectMember()));

        return root;
    }
}

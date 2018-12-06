package ah.jocelyne.greenin.user_hierarchy;
import ah.jocelyne.greenin.signup.RegisteredUser;

public class TreeNode<Role> {

    private Role role = null;
    private List<TreeNode<Role>> children = new ArrayList<>();
    private TreeNode<Role> parent = null;

    public TreeNode(Role role)
    {
        this.role = role;
    }

    public void getChildrenFunctions(TreeNode p)
    {
        //1- Data is object of type hirearchy
        //2- Each parentnode will go through its children and store them in an array
        //3- childnode has a counter for number of functions
        //4- parentnode (for loop) and invoke kids's function
    }

    public TreeNode<Role> addChild(TreeNode<Role> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<TreeNode<Role>> children)
    {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public List<TreeNode<Role>> getChildren()
    {
        return children;
    }

    public Role getData() {
        return data;
    }

    public void setData(Role data) {
        this.data = data;
    }

    private void setParent(TreeNode<Role> parent) {
        this.parent = parent;
    }

    public TreeNode<Role> getParent() {
        return parent;
    }

    private static <Role> void printTree(TreeNode<Role> TreeNode, String appender)
    {
        System.out.println(appender + TreeNode.getData());
        TreeNode.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

    public TreeNode getRoot()
    {
        if(parent == null)
        {
            return this;
        }
        return parent.getRoot();
    }
    public void deleteTreeNode()
    {
        if (parent != null)
        {
            int index = this.parent.getChildren().indexOf(this);
            this.parent.getChildren().remove(this);
            for (TreeNode<Role> each : getChildren())
            {
                each.setParent(this.parent);
            }
            this.parent.getChildren().addAll(index, this.getChildren());
        }
        else
        {
            deleteRootTreeNode();
        }
        this.getChildren().clear();
    }

    public TreeNode<Role> deleteRootTreeNode() {
        if (parent != null)
        {
            throw new IllegalStateException("deleteRootTreeNode not called on root");
        }
        TreeNode<Role> newParent = null;
        if (!getChildren().isEmpty())
        {
            newParent = getChildren().get(0);
            newParent.setParent(null);
            getChildren().remove(0);

            for (TreeNode<Role> each : getChildren())
            {
                each.setParent(newParent);
            }
            newParent.getChildren().addAll(getChildren());
        }
        this.getChildren().clear();
        return newParent;
    }
}
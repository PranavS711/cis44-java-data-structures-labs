/**
 * This class builds a company hierarchy tree and demonstrates traversals.
 */
public class CompanyTreeDriver {
    public static void main(String[] args) {
        // Build the tree
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Department heads
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // VP of Sales children
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        // VP of Engineering children
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // Dev Team Lead children
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        // Perform traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}

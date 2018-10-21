import java.util.*;
/* Class to find maximum profit by choosing best route where the next element is the multiple of previous element */
public class MaximumProfitFinder {
    private static List<TreeNode> nodeList = new ArrayList<>();
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumbers = scanner.nextInt();
        int profitGain[] = new int[totalNumbers];
        for (int i = 0; i < totalNumbers; i++) {
            profitGain[i] = scanner.nextInt();
        }
        Arrays.sort(profitGain);
        TreeNode rootNode = new TreeNode(0);
        for(int inputId : profitGain) {
            TreeNode node = new TreeNode(inputId);
            rootNode.addChild(node);
            nodeList.add(node);
        }
        for(TreeNode node : nodeList) {
            treeConstruct(node, nodeList);
        }
        List<List<TreeNode>> lists = TreePaths.getPaths(rootNode);
        int finalResult = 0;
        for(List<TreeNode> list : lists) {
            int tempResult = 0;
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).getValue());
                tempResult += list.get(i).getValue();
                if(i != list.size() - 1) {
                    System.out.print("-");
                }
            }
            if(tempResult > finalResult) {
                finalResult = tempResult;
            }
            System.out.println();
        }
        System.out.println("Max profit - " + finalResult);
    }

    private static void treeConstruct(TreeNode node, List<TreeNode> nodeLists) {
        for(TreeNode eachNode:nodeLists) {
            if(eachNode.getValue() <= node.getValue()) {
                continue;
            }
            if((eachNode.getValue() % node.getValue()) == 0) {
                TreeNode newNode = new TreeNode(eachNode.getValue());
                node.addChild(newNode);
                treeConstruct(newNode, nodeLists);
            }
        }
    }

    public static class TreeNode {
        private int value;
        private TreeNode parent;
        private List<TreeNode> children;

        public TreeNode(int value) {
            this.value = value;
            this.children = new LinkedList<>();
        }

        public void addChild(TreeNode child) {
            this.children.add(child);
            child.setParent(this);
        }

        public List<TreeNode> getChildren() {
            return Collections.unmodifiableList(this.children);
        }

        private void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public int getValue() {
            return this.value;
        }

    }

    public static class TreePaths {
        private static List<List<TreeNode>> getPaths0(TreeNode node) {
            List<List<TreeNode>> retLists = new ArrayList<>();

            if(node.getChildren().size() == 0) {
                List<TreeNode> leafList = new LinkedList<>();
                leafList.add(node);
                retLists.add(leafList);
            } else {
                for (TreeNode childNode : node.getChildren()) {
                    List<List<TreeNode>> nodeLists = getPaths0(childNode);
                    for (List<TreeNode> nodeList : nodeLists) {
                        nodeList.add(0, node);
                        retLists.add(nodeList);
                    }
                }
            }

            return retLists;
        }

        public static List<List<TreeNode>> getPaths(TreeNode head) {
            if(head == null) {
                return new ArrayList<>();
            } else {
                return getPaths0(head);
            }
        }
    }
}
